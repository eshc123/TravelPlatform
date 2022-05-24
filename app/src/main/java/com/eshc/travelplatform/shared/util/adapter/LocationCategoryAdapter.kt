package com.eshc.travelplatform.shared.util.adapter

import com.eshc.travelplatform.BR
import com.eshc.travelplatform.R
import com.eshc.domain.model.LocationCategory
import com.eshc.travelplatform.databinding.ItemLocationCategoryBinding
import com.eshc.travelplatform.ui.base.BaseRecyclerViewAdapter

class LocationCategoryAdapter()  : BaseRecyclerViewAdapter<LocationCategory, ItemLocationCategoryBinding>(
    layoutResId = R.layout.item_location_category,
    bindingVariableId = BR.locationCategory
) {
    override fun onBindViewHolder(holder: ViewHolder<ItemLocationCategoryBinding>, position: Int) {
        super.onBindViewHolder(holder, position)

    }
}