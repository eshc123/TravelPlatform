package com.eshc.travelplatform.ui.plan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.FragmentRecommendBinding
import com.eshc.travelplatform.shared.util.adapter.RecommendationAdapter


class RecommendFragment : Fragment() {
    private lateinit var binding: FragmentRecommendBinding
    private lateinit var recommendViewModel : RecommendViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recommendViewModel= ViewModelProvider(this, RecommendViewModelFactory())
            .get(RecommendViewModel::class.java)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_recommend, container, false)

        val adapter = RecommendationAdapter()
        binding.rvRecommendation.adapter = adapter

        recommendViewModel.recommendations.observe(viewLifecycleOwner, Observer {
            adapter.replaceAll(it)
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}