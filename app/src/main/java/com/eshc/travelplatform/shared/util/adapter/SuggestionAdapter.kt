package com.eshc.travelplatform.shared.util.adapter

import com.eshc.travelplatform.BR
import com.eshc.travelplatform.R
import com.eshc.travelplatform.data.plan.model.LocationCategory
import com.eshc.travelplatform.data.plan.model.Suggestion
import com.eshc.travelplatform.databinding.ItemLocationCategoryBinding
import com.eshc.travelplatform.databinding.ItemSuggestionBinding
import com.eshc.travelplatform.ui.base.BaseRecyclerViewAdapter

class SuggestionAdapter()  : BaseRecyclerViewAdapter<Suggestion, ItemSuggestionBinding>(
    layoutResId = R.layout.item_suggestion,
    bindingVariableId = BR.suggestion
) {
    override fun onBindViewHolder(holder: ViewHolder<ItemSuggestionBinding>, position: Int) {
        super.onBindViewHolder(holder, position)

    }
}