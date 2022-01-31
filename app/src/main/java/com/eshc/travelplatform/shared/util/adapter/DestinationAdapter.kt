package com.eshc.travelplatform.shared.util.adapter

import com.eshc.travelplatform.BR
import com.eshc.travelplatform.R
import com.eshc.travelplatform.ui.base.BaseRecyclerViewAdapter
import com.eshc.travelplatform.domain.model.Destination
import com.eshc.travelplatform.databinding.ItemDestinationBinding

class DestinationAdapter()  : BaseRecyclerViewAdapter<Destination,ItemDestinationBinding>(
    layoutResId = R.layout.item_destination,
    bindingVariableId = BR.destination
) {
    override fun onBindViewHolder(holder: ViewHolder<ItemDestinationBinding>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.setOnClickListener {

        }
    }
}