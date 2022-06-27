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
import androidx.navigation.fragment.findNavController
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.FragmentPlanBinding
import com.eshc.domain.model.Itinerary
import com.eshc.travelplatform.util.adapter.CourseAdapter
import com.eshc.travelplatform.util.adapter.SpotAdapter
import com.eshc.travelplatform.util.dpToPx
import com.eshc.travelplatform.ui.recommend.RecommendActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior

class PlanFragment : Fragment() {

    private val planViewModel: PlanViewModel by viewModels()
    private lateinit var binding : FragmentPlanBinding
    val test = "test"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_plan, container, false)
        binding.fragment = this

        val textView: AppCompatTextView = binding.tvPlanNum
        val recommendationAdapter = SpotAdapter()
        val courseAdapter = CourseAdapter(this)

        binding.rvRecommendation.adapter = recommendationAdapter
        binding.rvCourse.adapter = courseAdapter

        planViewModel.planNum.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        planViewModel.recommendSpots.observe(viewLifecycleOwner, Observer {
            recommendationAdapter.replaceAll(it)
        })
        planViewModel.courses.observe(viewLifecycleOwner, Observer {
            courseAdapter.replaceAll(it)
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
        binding.clMy.setOnClickListener {
            navigateToMySchedule()
        }
    }
    private fun navigateToMySchedule(){
        findNavController().navigate(R.id.action_navigation_plan_to_fragment_myschedule)
    }

    private fun navigateToSearch(){
        findNavController().navigate(R.id.action_navigation_plan_to_fragment_search)
    }
    private fun startRecommend(){
        activity?.startActivity(Intent(activity, RecommendActivity::class.java))
    }

}