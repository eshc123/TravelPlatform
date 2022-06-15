package com.eshc.travelplatform.ui.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.FragmentMypageBinding
import com.eshc.travelplatform.databinding.FragmentUserEditBinding


class UserEditFragment : Fragment() {

    private val mypageViewModel: MypageViewModel by viewModels()
    private lateinit var binding: FragmentUserEditBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_edit, container, false)
        binding.fragment = this



        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }
}