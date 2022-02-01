package com.eshc.travelplatform.shared.util.adapter

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.eshc.travelplatform.BR
import com.eshc.travelplatform.R
import com.eshc.travelplatform.domain.model.Suggestion
import com.eshc.travelplatform.databinding.ItemSuggestionBinding
import com.eshc.travelplatform.ui.base.BaseRecyclerViewAdapter
import com.eshc.travelplatform.ui.plan.SearchFragment

class SuggestionAdapter(val fragment : Fragment)  : BaseRecyclerViewAdapter<Suggestion, ItemSuggestionBinding>(
    layoutResId = R.layout.item_suggestion,
    bindingVariableId = BR.suggestion
) {
    override fun onBindViewHolder(holder: ViewHolder<ItemSuggestionBinding>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.setOnClickListener {
            (fragment as SearchFragment).addMarker(holder.binding.suggestion!!)
        }
    }
}