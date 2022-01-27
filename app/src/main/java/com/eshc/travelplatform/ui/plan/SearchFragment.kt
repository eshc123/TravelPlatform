package com.eshc.travelplatform.ui.plan

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.FragmentSearchBinding


class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_search, container, false)

        val kakaoMapView = net.daum.mf.map.api.MapView(activity)
        (binding.mapview as ViewGroup).addView(kakaoMapView)

        binding.etSearch.setOnFocusChangeListener { v, hasFocus ->
            if(hasFocus){
                binding.vBackground.visibility = View.VISIBLE
            }
            else {
                binding.vBackground.visibility = View.GONE
            }
        }
        binding.vBackground.setOnTouchListener { v, event ->
            binding.etSearch.clearFocus()
            hideKeyboard()
            return@setOnTouchListener false
        }

        return binding.root
    }
    private fun hideKeyboard(){
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(binding.etSearch.windowToken,0)
    }
}