package com.eshc.travelplatform.ui.plan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.FragmentScheduleBinding
import com.eshc.travelplatform.shared.util.dpToPx
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class ScheduleFragment : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentScheduleBinding
    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTransparentTheme
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_schedule,container,false)
        this.dialog?.window?.setDimAmount(0f)
        binding.clContainer.maxHeight = WindowManager.LayoutParams.MATCH_PARENT
        (dialog as BottomSheetDialog).behavior.apply {
            peekHeight = 200.dpToPx()
        }
        addScheduleView()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (dialog as BottomSheetDialog).behavior.apply {
            isFitToContents = true
        }

    }
    fun addScheduleView(){
        val view = layoutInflater.inflate(R.layout.layout_schedule,binding.llContainer,false)
        binding.llContainer.addView(view)
    }
}