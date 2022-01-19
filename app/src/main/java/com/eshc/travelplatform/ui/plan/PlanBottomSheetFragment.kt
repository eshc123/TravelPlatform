package com.eshc.travelplatform.ui.plan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eshc.travelplatform.R
import com.eshc.travelplatform.adapter.DestinationAdapter
import com.eshc.travelplatform.data.plan.Destination
import com.eshc.travelplatform.databinding.FragmentPlanBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class PlanBottomSheetFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentPlanBottomSheetBinding
    private val adapter by lazy { DestinationAdapter() }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_plan_bottom_sheet,container,false)
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
        adapter.replaceAll(listOf(
            Destination(
            "서울"),Destination("부산"),Destination("대구"),Destination("대전"),Destination("강릉"),Destination("속초"),Destination(
                "제주"),Destination("김해"),Destination("목포"),Destination("전주"),Destination("춘천"),Destination("진주"),Destination(
                "광주"),Destination("인천"),Destination("가평"),Destination("경주"),Destination("울산"),Destination("천안")))

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