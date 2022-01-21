package com.eshc.travelplatform.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.FragmentHomeBinding
import com.eshc.travelplatform.ui.plan.PlanBottomSheetFragment

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private lateinit var binding : FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.fragment = this

        val textView: TextView = binding.textHome
        homeViewModel.text.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textHome.setOnClickListener {
            navigateToPlan()

//            val planBottomSheetFragment = PlanBottomSheetFragment()
//            planBottomSheetFragment.show(childFragmentManager,planBottomSheetFragment.tag)
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun navigateToPlan(){
        findNavController().navigate(R.id.fragment_plan)
    }
}