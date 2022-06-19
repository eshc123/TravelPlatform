package com.eshc.travelplatform.ui.plan

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.FragmentMyscheduleBinding
import com.eshc.travelplatform.shared.util.adapter.MyscheduleAdapter

class MyscheduleFragment : Fragment() {

    private val myscheduleViewModel: MyscheduleViewModel by viewModels()
    private lateinit var binding: FragmentMyscheduleBinding
    val adapter = MyscheduleAdapter(this)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_myschedule, container, false)
        binding.rvMyschedule.adapter = adapter

        myscheduleViewModel.itineraries.observe(viewLifecycleOwner, Observer {
            adapter.replaceAll(it)
        })


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}