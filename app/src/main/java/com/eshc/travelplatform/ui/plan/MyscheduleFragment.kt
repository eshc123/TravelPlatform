package com.eshc.travelplatform.ui.plan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.FragmentMyscheduleBinding

class MyscheduleFragment : Fragment() {

    private val myscheduleViewModel: MyscheduleViewModel by viewModels<MyscheduleViewModel>()
    private lateinit var binding: FragmentMyscheduleBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_myschedule, container, false)



        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}