package com.eshc.travelplatform.shared.util.adapter

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.drawable.GradientDrawable
import androidx.core.content.ContextCompat
import com.eshc.travelplatform.BR
import com.eshc.travelplatform.R
import com.eshc.travelplatform.domain.model.Condition
import com.eshc.travelplatform.databinding.ItemConditionBinding
import com.eshc.travelplatform.ui.base.BaseRecyclerViewAdapter

class ConditionAdapter(val context : Context)  : BaseRecyclerViewAdapter<Condition,ItemConditionBinding>(
    layoutResId = R.layout.item_condition,
    bindingVariableId = BR.condition
) {
    var selectedItemPosition = 0
    override fun onBindViewHolder(holder: ViewHolder<ItemConditionBinding>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.setOnClickListener {
            selectedItemPosition = position
            notifyDataSetChanged()
        }
        if (selectedItemPosition == position) {
            holder.binding.clContainer.background = ContextCompat.getDrawable(context,R.drawable.background_corner_round_main)
            holder.binding.tvTitle.setTextColor(Color.WHITE)
        } else {
            holder.binding.clContainer.background = ContextCompat.getDrawable(context,R.drawable.background_corner_round)
            holder.binding.tvTitle.setTextColor(ContextCompat.getColor(context,R.color.content_color))
        }
    }
}
