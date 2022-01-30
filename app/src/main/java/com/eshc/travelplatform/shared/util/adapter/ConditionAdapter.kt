package com.eshc.travelplatform.shared.util.adapter

import com.eshc.travelplatform.BR
import com.eshc.travelplatform.R
import com.eshc.travelplatform.data.plan.model.Condition
import com.eshc.travelplatform.data.plan.model.Course
import com.eshc.travelplatform.data.plan.model.Recommendation
import com.eshc.travelplatform.databinding.ItemConditionBinding
import com.eshc.travelplatform.databinding.ItemCourseBinding
import com.eshc.travelplatform.ui.base.BaseRecyclerViewAdapter
import com.eshc.travelplatform.databinding.ItemRecommendationBinding

class ConditionAdapter()  : BaseRecyclerViewAdapter<Condition,ItemConditionBinding>(
    layoutResId = R.layout.item_condition,
    bindingVariableId = BR.condition
) {
    override fun onBindViewHolder(holder: ViewHolder<ItemConditionBinding>, position: Int) {
        super.onBindViewHolder(holder, position)

    }
}