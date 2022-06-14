package com.eshc.travelplatform.shared.util.adapter

import androidx.fragment.app.Fragment
import com.eshc.domain.model.Itinerary
import com.eshc.travelplatform.BR
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.ItemSuggestionBinding
import com.eshc.domain.model.Spot
import com.eshc.travelplatform.databinding.ItemMyscheduleBinding
import com.eshc.travelplatform.ui.base.BaseRecyclerViewAdapter
import com.eshc.travelplatform.ui.plan.SearchFragment

class MyscheduleAdapter  : BaseRecyclerViewAdapter<Itinerary, ItemMyscheduleBinding>(
    layoutResId = R.layout.item_myschedule,
    bindingVariableId = BR.itinerary
) {
    override fun onBindViewHolder(holder: ViewHolder<ItemMyscheduleBinding>, position: Int) {
        super.onBindViewHolder(holder, position)

    }
}