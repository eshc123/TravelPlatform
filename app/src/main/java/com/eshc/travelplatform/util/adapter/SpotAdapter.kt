package com.eshc.travelplatform.util.adapter

import com.eshc.travelplatform.BR
import com.eshc.travelplatform.R
import com.eshc.travelplatform.ui.base.BaseRecyclerViewAdapter
import com.eshc.travelplatform.databinding.ItemSpotBinding
import com.eshc.domain.model.Spot

class SpotAdapter()  : BaseRecyclerViewAdapter<Spot,ItemSpotBinding>(
    layoutResId = R.layout.item_spot,
    bindingVariableId = BR.spot
) {
    override fun onBindViewHolder(holder: ViewHolder<ItemSpotBinding>, position: Int) {
        super.onBindViewHolder(holder, position)

    }
}