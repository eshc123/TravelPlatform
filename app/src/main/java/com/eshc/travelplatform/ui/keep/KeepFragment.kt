package com.eshc.travelplatform.ui.keep

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.FragmentKeepBinding
import com.eshc.travelplatform.util.adapter.KeepSpotAdapter

class KeepFragment : Fragment() {

    private val keepViewModel: KeepViewModel by viewModels( )
    private lateinit var binding: FragmentKeepBinding

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