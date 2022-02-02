package com.eshc.travelplatform.ui.plan

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eshc.travelplatform.R
import com.eshc.travelplatform.shared.util.adapter.DestinationAdapter
import com.eshc.travelplatform.domain.model.Destination
import com.eshc.travelplatform.databinding.FragmentPlanBottomSheetBinding
import com.eshc.travelplatform.databinding.FragmentSearchDetailBinding
import com.eshc.travelplatform.domain.model.Suggestion
import com.eshc.travelplatform.shared.util.dpToPx
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment


class SearchDetailFragment(suggestion: Suggestion) : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentSearchDetailBinding
    var place = suggestion
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
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_search_detail,container,false)
        this.dialog?.window?.setDimAmount(0f)
        binding.frgment = this
        binding.clContainer.maxHeight = WindowManager.LayoutParams.MATCH_PARENT
        (dialog as BottomSheetDialog).behavior.apply {
            peekHeight = 200.dpToPx()
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (dialog as BottomSheetDialog).behavior.apply {
            isFitToContents = true
        }

    }

}