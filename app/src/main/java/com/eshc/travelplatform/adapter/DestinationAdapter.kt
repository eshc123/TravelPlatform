package com.eshc.travelplatform.adapter

import androidx.lifecycle.ViewModel
import com.eshc.travelplatform.BR
import com.eshc.travelplatform.R
import com.eshc.travelplatform.base.BaseRecyclerViewAdapter
import com.eshc.travelplatform.data.plan.Destination
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