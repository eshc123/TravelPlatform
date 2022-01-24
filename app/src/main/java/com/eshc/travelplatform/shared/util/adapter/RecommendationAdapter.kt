package com.eshc.travelplatform.shared.util.adapter

import com.eshc.travelplatform.BR
import com.eshc.travelplatform.R
import com.eshc.travelplatform.data.plan.model.Recommendation
import com.eshc.travelplatform.ui.base.BaseRecyclerViewAdapter
import com.eshc.travelplatform.databinding.ItemRecommendationBinding

class RecommendationAdapter()  : BaseRecyclerViewAdapter<Recommendation,ItemRecommendationBinding>(
    layoutResId = R.layout.item_recommendation,
    bindingVariableId = BR.recommendation
) {
    override fun onBindViewHolder(holder: ViewHolder<ItemRecommendationBinding>, position: Int) {
        super.onBindViewHolder(holder, position)

    }
}