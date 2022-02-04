package com.eshc.travelplatform.ui.plan

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.AppCompatTextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.marginBottom
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.FragmentPlanBinding
import com.eshc.travelplatform.domain.model.Suggestion
import com.eshc.travelplatform.shared.util.adapter.CourseAdapter
import com.eshc.travelplatform.shared.util.adapter.RecommendationAdapter
import com.eshc.travelplatform.shared.util.dpToPx
import com.eshc.travelplatform.ui.recommend.RecommendActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog

class PlanFragment : Fragment() {

    private lateinit var planViewModel: PlanViewModel
    private lateinit var binding : FragmentPlanBinding
    private lateinit var scheduleFragment: ScheduleFragment

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
        val recommendationAdapter = RecommendationAdapter()
        val courseAdapter = CourseAdapter()
        binding.rvRecommendation.adapter = recommendationAdapter
        binding.rvCourse.adapter = courseAdapter

        planViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        planViewModel.recommendations.observe(viewLifecycleOwner, Observer {
            recommendationAdapter.replaceAll(it)
        })
        planViewModel.courses.observe(viewLifecycleOwner, Observer {
            courseAdapter.replaceAll(it)
        })

        //openSearchDetailBottomSheet()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.clAdd.setOnClickListener {
            startRecommend()

//            val planBottomSheetFragment = PlanBottomSheetFragment()
//            planBottomSheetFragment.show(childFragmentManager,planBottomSheetFragment.tag)
        }
        binding.ivSearch.setOnClickListener {
            navigateToSearch()
        }
        initScheduleBottomSheet()
    }


    private fun navigateToSearch(){
        findNavController().navigate(R.id.action_navigation_plan_to_fragment_search)
    }
    private fun startRecommend(){
        activity?.startActivity(Intent(activity, RecommendActivity::class.java))
    }

    private fun initScheduleBottomSheet(){
        val bottomSheet = binding.clBottomContainer
        val bottomSheetBehavior = BottomSheetBehavior.from(bottomSheet)

        bottomSheetBehavior.peekHeight = 200.dpToPx()
        val view = layoutInflater.inflate(R.layout.layout_schedule,binding.llContainer,false)
        binding.llContainer.addView(view)
        binding.clTop.setPadding(0,0,0,200.dpToPx())
    }

}