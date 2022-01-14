package com.eshc.travelplatform.ui.plan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eshc.travelplatform.R
import com.eshc.travelplatform.adapter.DestinationAdapter
import com.eshc.travelplatform.databinding.FragmentPlanBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class PlanFragment : BottomSheetDialogFragment() {
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
        (dialog as BottomSheetDialog).behavior.apply {
            isFitToContents = true
            state = BottomSheetBehavior.STATE_EXPANDED
            skipCollapsed = true
        }
        val next = binding.temp
        val previous1 = binding.temp1
        val recyclerView = binding.rvDestination
        val locationLayout = binding.llLocation
        val calendarLayout = binding.llCalendar
        initRecyclerView(recyclerView)
        adapter.replaceAll(listOf("","","","","","","","","","","","","","","","","",""))

        next.setOnClickListener {
            val offsetFromTop = 200
            (dialog as BottomSheetDialog).behavior.apply {
                //isFitToContents = false
                state = BottomSheetBehavior.STATE_COLLAPSED
                peekHeight = 1600
                    //expandedOffset = offsetFromTop
            }
            locationLayout.visibility = View.GONE
            calendarLayout.visibility = View.VISIBLE
        }
        previous1.setOnClickListener {
            (dialog as BottomSheetDialog).behavior.apply {
                state = BottomSheetBehavior.STATE_EXPANDED
                isFitToContents = true

            }
            locationLayout.visibility = View.VISIBLE
            calendarLayout.visibility = View.GONE
        }
    }
    private fun initRecyclerView(rv:RecyclerView){
        val lm = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        lm.scrollToPositionWithOffset(0,0)

        rv.layoutManager = lm
        rv.adapter = adapter
    }
}