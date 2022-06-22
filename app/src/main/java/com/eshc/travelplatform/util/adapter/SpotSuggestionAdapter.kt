package com.eshc.travelplatform.util.adapter

import androidx.fragment.app.Fragment
import com.eshc.travelplatform.BR
import com.eshc.travelplatform.R
import com.eshc.travelplatform.databinding.ItemSuggestionBinding
import com.eshc.domain.model.Spot
import com.eshc.travelplatform.ui.base.BaseRecyclerViewAdapter
import com.eshc.travelplatform.ui.plan.SearchFragment

class SpotSuggestionAdapter(val fragment : Fragment)  : BaseRecyclerViewAdapter<Spot, ItemSuggestionBinding>(
    layoutResId = R.layout.item_suggestion,
    bindingVariableId = BR.spot_suggestion
) {
    override fun onBindViewHolder(holder: ViewHolder<ItemSuggestionBinding>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.setOnClickListener {
            (fragment as SearchFragment).addMarker(holder.binding.spotSuggestion!!)
        }
    }
}