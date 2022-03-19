package com.eshc.travelplatform.ui.mypage

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
import com.eshc.travelplatform.databinding.FragmentMypageBinding
import com.eshc.travelplatform.shared.util.adapter.KeepSpotAdapter
import com.eshc.travelplatform.ui.keep.KeepViewModel
import com.eshc.travelplatform.ui.keep.KeepViewModelFactory

class MypageFragment : Fragment() {

    private lateinit var mypageViewModel: MypageViewModel
    private lateinit var binding: FragmentMypageBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mypageViewModel= ViewModelProvider(this, MyPageViewModelFactory())
            .get(MypageViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mypage, container, false)
        binding.fragment = this
        binding.viewModel = mypageViewModel
        mypageViewModel.keepSpots.observe(viewLifecycleOwner, Observer {
            binding.tvKeepNum.text = it.size.toString()
        })


        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}