package com.eshc.travelplatform.ui.plan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eshc.travelplatform.R
import com.eshc.travelplatform.data.plan.model.LocationCategory
import com.eshc.travelplatform.data.plan.model.Recommendation
import com.eshc.travelplatform.data.plan.model.Spot

class SearchViewModel : ViewModel() {
    private val _categories = MutableLiveData<MutableList<LocationCategory>>()
    val categories: LiveData<MutableList<LocationCategory>> = _categories
    init {
        _categories.value = mutableListOf(
            LocationCategory("겨울필수코스",R.drawable.ic_snowflake),
            LocationCategory("맛집",R.drawable.ic_dining),
            LocationCategory("카페",R.drawable.ic_cafe),
            LocationCategory("편의점",R.drawable.ic_convenience_store),
            LocationCategory("마트",R.drawable.ic_grocery_store)
        )
    }
}