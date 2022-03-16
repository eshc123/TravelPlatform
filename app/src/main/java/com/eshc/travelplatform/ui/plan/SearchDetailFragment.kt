package com.eshc.travelplatform.ui.plan

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatTextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.FragmentSearchDetailBinding
import com.eshc.travelplatform.domain.model.Spot
import com.eshc.travelplatform.shared.util.dpToPx
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch


class SearchDetailFragment(spotSuggestion: Spot) : BottomSheetDialogFragment() {
    private lateinit var binding: FragmentSearchDetailBinding
    private lateinit var searchViewModel : SearchViewModel
    var place = spotSuggestion
    override fun getTheme(): Int {
        return R.style.AppBottomSheetDialogTransparentTheme
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        searchViewModel= ViewModelProvider(this, SearchViewModelFactory())
            .get(SearchViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_search_detail,container,false)
        this.dialog?.window?.setDimAmount(0f)
        binding.fragment = this
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
    fun createWaitingDialog(){
        AlertDialog.Builder(requireContext(), R.style.AlertDialogTheme)
            .setView(R.layout.dialog_waiting)
            .show()
            .also { alertDialog ->
                val mActivity = activity
                if(alertDialog == null) {
                    return@also
                }
                val planButton = alertDialog.findViewById<AppCompatTextView>(R.id.btn_plan)
                planButton?.setOnClickListener {
                    alertDialog.dismiss()
                }

            }
    }
    fun postKeep(spot: Spot) {
        lifecycleScope.launch {
            searchViewModel.postKeep(spot)
        }
    }
}