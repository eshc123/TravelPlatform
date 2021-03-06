package com.eshc.travelplatform.ui.plan

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.FragmentPlanBinding
import com.eshc.domain.model.Itinerary
import com.eshc.travelplatform.databinding.FragmentPlanDetailBinding
import com.eshc.travelplatform.util.dpToPx
import com.eshc.travelplatform.ui.recommend.RecommendActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior

class PlanDetailFragment : Fragment() {

    private val planDetailViewModel: PlanDetailViewModel by viewModels()
    private lateinit var binding : FragmentPlanDetailBinding
    private lateinit var bottomSheet : ConstraintLayout
    private lateinit var bottomSheetBehavior : BottomSheetBehavior<ConstraintLayout>
    private lateinit var dailyScheduleViews : MutableList<View>


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_plan_detail, container, false)
        binding.fragment = this


        bottomSheet = binding.clBottomContainer
        bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)
        bottomSheetBehavior.state = BottomSheetBehavior.STATE_HIDDEN


        planDetailViewModel.itineraries.observe(viewLifecycleOwner, Observer {
            if(it.isNotEmpty()){
                dailyScheduleViews = mutableListOf()
                initScheduleBottomSheet(it)
                binding.tvDay.text = it.first().startDate.plus(" ~ ").plus(it.first().endDate)
                binding.tvSubtitle.text = it.first().description
            }
        })
        return binding.root
    }




    private fun navigateToSearch(){
        findNavController().navigate(R.id.action_navigation_plan_to_fragment_search)
    }

    fun initScheduleBottomSheet(itineraries: MutableList<Itinerary>){
        initBottomSheet()
        binding.clPlan.visibility = View.VISIBLE

        binding.ivSearchPlan.setOnClickListener {
            navigateToSearch()
        }
        addDailyScheduleViews(itineraries)


        //val dailyScheduleView = layoutInflater.inflate(R.layout.layout_itinerary,binding.llContainer,false)
       // binding.llContainer.addView(dailyScheduleView)
//        view.findViewById<RecyclerView>(R.id.rv_spot).adapter = SpotAdapter()
//        (view.findViewById<RecyclerView>(R.id.rv_spot).adapter as SpotAdapter).replaceAll(listOf(
//            Spot("?????? ?????????",0.0,0.0),Spot("?????????",0.0,0.0)
//        ))
//        val view1 = layoutInflater.inflate(R.layout.layout_schedule,binding.llContainer,false)
//
//        binding.llContainer.addView(view1)
//        view1.findViewById<RecyclerView>(R.id.rv_spot).adapter = SpotAdapter()
//        (view1.findViewById<RecyclerView>(R.id.rv_spot).adapter as SpotAdapter).replaceAll(listOf(
//            Spot("????????? ??????",0.0,0.0)
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
                    it.findViewById<AppCompatTextView>(R.id.tv_day).text = "${idx++}??????"
                    it.findViewById<ConstraintLayout>(R.id.cl_calendar).setOnClickListener {
                        navigateToSearch()
                    }
                    binding.llContainer.addView(it)
                }
            }
        }
    }
}