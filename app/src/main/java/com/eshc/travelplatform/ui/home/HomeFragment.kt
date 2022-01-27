package com.eshc.travelplatform.ui.home

import android.os.Build
import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.FragmentHomeBinding
import com.eshc.travelplatform.shared.util.adapter.CourseAdapter
import com.eshc.travelplatform.shared.util.adapter.RecommendationAdapter
import com.eshc.travelplatform.ui.MainActivity
import com.eshc.travelplatform.ui.plan.PlanBottomSheetFragment
import com.eshc.travelplatform.ui.plan.RecommendViewModel
import com.eshc.travelplatform.ui.plan.RecommendViewModelFactory
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding : FragmentHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeViewModel= ViewModelProvider(this, HomeViewModelFactory())
            .get(HomeViewModel::class.java)
           }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.fragment = this

        val textView: AppCompatTextView = binding.textHome
        val recommendationAdapter = RecommendationAdapter()
        val courseAdapter = CourseAdapter()
        binding.rvRecommendation.adapter = recommendationAdapter
        binding.rvCourse.adapter = courseAdapter

        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        homeViewModel.recommendations.observe(viewLifecycleOwner, Observer {
            recommendationAdapter.replaceAll(it)
        })
        homeViewModel.courses.observe(viewLifecycleOwner, Observer {
            courseAdapter.replaceAll(it)
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.clAdd.setOnClickListener {
            navigateToPlan()

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

    private fun navigateToPlan(){
        findNavController().navigate(R.id.action_navigation_home_to_fragment_plan)
    }
    private fun navigateToSearch(){
        findNavController().navigate(R.id.action_navigation_home_to_fragment_search)
    }
}