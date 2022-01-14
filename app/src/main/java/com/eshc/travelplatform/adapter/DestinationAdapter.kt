package com.eshc.travelplatform.adapter

import androidx.lifecycle.ViewModel
import com.eshc.travelplatform.R
import com.eshc.travelplatform.base.BaseRecyclerViewAdapter
import com.eshc.travelplatform.databinding.ItemDestinationBinding

class DestinationAdapter()  : BaseRecyclerViewAdapter<String,ItemDestinationBinding>(
    layoutResId = R.layout.item_destination
) {
    override fun onBindViewHolder(holder: ViewHolder<ItemDestinationBinding>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.setOnClickListener {

        }
    }
}