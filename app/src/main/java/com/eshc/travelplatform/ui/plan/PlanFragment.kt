package com.eshc.travelplatform.ui.plan

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.FragmentPlanBinding
import com.eshc.travelplatform.domain.model.Itinerary
import com.eshc.travelplatform.shared.util.adapter.CourseAdapter
import com.eshc.travelplatform.shared.util.adapter.SpotAdapter
import com.eshc.travelplatform.shared.util.dpToPx
import com.eshc.travelplatform.ui.recommend.RecommendActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior

class PlanFragment : Fragment() {

    private lateinit var planViewModel: PlanViewModel
    private lateinit var binding : FragmentPlanBinding
    private lateinit var bottomSheet : ConstraintLayout
    private lateinit var bottomSheetBehavior : BottomSheetBehavior<ConstraintLayout>
    private lateinit var dailyScheduleViews : MutableList<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        planViewModel= ViewModelProvider(this, PlanViewModelFactory())
            .get(PlanViewModel::class.java)
           }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_plan, container, false)
        binding.fragment = this

        val textView: AppCompatTextView = binding.textHome
        val recommendationAdapter = SpotAdapter()
        val courseAdapter = CourseAdapter(this)
        bottomSheet = binding.clBottomContainer
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN

        binding.rvRecommendation.adapter = recommendationAdapter
        binding.rvCourse.adapter = courseAdapter

        planViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        planViewModel.recommendSpots.observe(viewLifecycleOwner, Observer {
            recommendationAdapter.replaceAll(it)
        })
        planViewModel.courses.observe(viewLifecycleOwner, Observer {
            courseAdapter.replaceAll(it)
        })
        planViewModel.itineraries.observe(viewLifecycleOwner, Observer {
            if(it.isNotEmpty()){
                dailyScheduleViews = mutableListOf()
                initScheduleBottomSheet(it)
                binding.tvDay.text = it.first().startDate.plus(" ~ ").plus(it.first().endDate)
                binding.tvSubtitle.text = it.first().description
            }
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.clAdd.setOnClickListener {
            startRecommend()
        }
        binding.ivSearch.setOnClickListener {
            navigateToSearch()
        }
    }


    private fun navigateToSearch(){
        findNavController().navigate(R.id.action_navigation_plan_to_fragment_search)
    }
    private fun startRecommend(){
        activity?.startActivity(Intent(activity, RecommendActivity::class.java))
    }

    fun initScheduleBottomSheet(itineraries: MutableList<Itinerary>){
        initBottomSheet()
        binding.clTop.visibility = View.GONE
        binding.clPlan.visibility = View.VISIBLE
        binding.clTop.setPadding(0,0,0,200.dpToPx())

        binding.ivSearchPlan.setOnClickListener {
            navigateToSearch()
        }
        addDailyScheduleViews(itineraries)


        //val dailyScheduleView = layoutInflater.inflate(R.layout.layout_itinerary,binding.llContainer,false)
       // binding.llContainer.addView(dailyScheduleView)
//        view.findViewById<RecyclerView>(R.id.rv_spot).adapter = SpotAdapter()
//        (view.findViewById<RecyclerView>(R.id.rv_spot).adapter as SpotAdapter).replaceAll(listOf(
//            Spot("해동 용궁사",0.0,0.0),Spot("두번째",0.0,0.0)
//        ))
//        val view1 = layoutInflater.inflate(R.layout.layout_schedule,binding.llContainer,false)
//
//        binding.llContainer.addView(view1)
//        view1.findViewById<RecyclerView>(R.id.rv_spot).adapter = SpotAdapter()
//        (view1.findViewById<RecyclerView>(R.id.rv_spot).adapter as SpotAdapter).replaceAll(listOf(
//            Spot("영화의 전당",0.0,0.0)
//        ))
    }
    private fun initBottomSheet() {
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
        bottomSheetBehavior.peekHeight = 200.dpToPx()
        bottomSheetBehavior.isHideable = false
    }
    private fun addDailyScheduleViews(itineraries: MutableList<Itinerary>){
        itineraries.first().schedules?.let{
            it.forEach { _ ->
                dailyScheduleViews.add(layoutInflater.inflate(R.layout.layout_itinerary,binding.llContainer,false))
            }.apply {
                var idx = 1
                dailyScheduleViews.forEach {
                    it.findViewById<AppCompatTextView>(R.id.tv_day).text = "${idx++}일차"
                    it.findViewById<ConstraintLayout>(R.id.cl_calendar).setOnClickListener {
                        navigateToSearch()
                    }
                    binding.llContainer.addView(it)
                }
            }
        }
    }
}