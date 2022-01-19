package com.eshc.travelplatform.ui.plan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eshc.travelplatform.R
import com.eshc.travelplatform.adapter.DestinationAdapter
import com.eshc.travelplatform.data.plan.Destination
import com.eshc.travelplatform.databinding.FragmentPlanBinding
import com.eshc.travelplatform.databinding.FragmentPlanBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayout


class PlanFragment : Fragment() {
    private lateinit var binding: FragmentPlanBinding
    private val adapter by lazy { DestinationAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_plan,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tabLayout = binding.tablayout

        initTabLayout(tabLayout)
    }
    private fun initRecyclerView(rv:RecyclerView){
        val lm = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        lm.scrollToPositionWithOffset(0,0)

        rv.layoutManager = lm
        rv.adapter = adapter
    }
    private fun initTabLayout(tabLayout: TabLayout){
        val tabNames = listOf("지도로 보기","목록으로 보기")
        for(tabName in tabNames){
            val newTab = tabLayout.newTab().setText(tabName)
            tabLayout.addTab(newTab)
        }
    }
}