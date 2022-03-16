package com.eshc.travelplatform.shared.util.adapter

import com.eshc.travelplatform.BR
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.ItemKeepSpotBinding
import com.eshc.travelplatform.ui.base.BaseRecyclerViewAdapter
import com.eshc.travelplatform.databinding.ItemSpotBinding
import com.eshc.travelplatform.domain.model.Spot

class KeepSpotAdapter()  : BaseRecyclerViewAdapter<Spot,ItemKeepSpotBinding>(
    layoutResId = R.layout.item_keep_spot,
    bindingVariableId = BR.spot
) {
    override fun onBindViewHolder(holder: ViewHolder<ItemKeepSpotBinding>, position: Int) {
        super.onBindViewHolder(holder, position)

    }
}