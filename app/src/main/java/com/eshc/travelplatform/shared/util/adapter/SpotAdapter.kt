package com.eshc.travelplatform.shared.util.adapter

import androidx.lifecycle.ViewModel
import com.eshc.travelplatform.BR
import com.eshc.travelplatform.R
import com.eshc.travelplatform.ui.base.BaseRecyclerViewAdapter
import com.eshc.travelplatform.domain.model.Spot
import com.eshc.travelplatform.databinding.ItemSpotBinding

class SpotAdapter(val vm : ViewModel)  : BaseRecyclerViewAdapter<Spot,ItemSpotBinding>(
    layoutResId = R.layout.item_spot,
    bindingVariableId = BR.spot
) {
    override fun onBindViewHolder(holder: ViewHolder<ItemSpotBinding>, position: Int) {
        super.onBindViewHolder(holder, position)

    }
}