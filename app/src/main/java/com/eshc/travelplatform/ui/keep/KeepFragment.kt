package com.eshc.travelplatform.ui.keep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.FragmentKeepBinding
import com.eshc.travelplatform.shared.util.adapter.KeepSpotAdapter
import com.eshc.travelplatform.shared.util.adapter.SpotAdapter
import com.eshc.travelplatform.ui.plan.PlanViewModel
import com.eshc.travelplatform.ui.plan.PlanViewModelFactory

class KeepFragment : Fragment() {

    private lateinit var keepViewModel: KeepViewModel
    private lateinit var binding: FragmentKeepBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        keepViewModel= ViewModelProvider(this, KeepViewModelFactory())
            .get(KeepViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_keep, container, false)
        binding.fragment = this
        val keepSpotAdapter = KeepSpotAdapter()
        binding.rvKeepSpot.adapter = keepSpotAdapter

        keepViewModel.keepSpots.observe(viewLifecycleOwner, Observer {
            keepSpotAdapter.replaceAll(it)
        })

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}