package com.eshc.travelplatform.ui.plan

import android.content.Intent
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.FragmentPlanBinding
import com.eshc.travelplatform.shared.util.adapter.CourseAdapter
import com.eshc.travelplatform.shared.util.adapter.RecommendationAdapter
import com.eshc.travelplatform.ui.recommend.RecommendActivity

class PlanFragment : Fragment() {

    private lateinit var planViewModel: PlanViewModel
    private lateinit var binding : FragmentPlanBinding

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

    }
    override fun onDestroyView() {
        super.onDestroyView()
    }


    private fun navigateToSearch(){
        findNavController().navigate(R.id.action_navigation_plan_to_fragment_search)
    }
    private fun startRecommend(){
        activity?.startActivity(Intent(activity, RecommendActivity::class.java))
    }
}