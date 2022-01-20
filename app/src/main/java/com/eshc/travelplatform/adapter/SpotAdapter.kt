package com.eshc.travelplatform.adapter

import androidx.lifecycle.ViewModel
import com.eshc.travelplatform.BR
import com.eshc.travelplatform.R
import com.eshc.travelplatform.base.BaseRecyclerViewAdapter
import com.eshc.travelplatform.data.plan.Destination
import com.eshc.travelplatform.data.plan.Spot
import com.eshc.travelplatform.databinding.ItemDestinationBinding
import com.eshc.travelplatform.databinding.ItemSpotBinding

class SpotAdapter()  : BaseRecyclerViewAdapter<Spot,ItemSpotBinding>(
    layoutResId = R.layout.item_spot,
    bindingVariableId = BR.spot
) {
    override fun onBindViewHolder(holder: ViewHolder<ItemSpotBinding>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.setOnClickListener {

        }
    }
}