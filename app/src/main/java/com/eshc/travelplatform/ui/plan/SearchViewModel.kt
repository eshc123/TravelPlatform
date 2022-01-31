package com.eshc.travelplatform.ui.plan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eshc.travelplatform.R
import com.eshc.travelplatform.domain.model.LocationCategory
import com.eshc.travelplatform.domain.model.Suggestion

class SearchViewModel : ViewModel() {
    private val _categories = MutableLiveData<MutableList<LocationCategory>>()
    val categories: LiveData<MutableList<LocationCategory>> = _categories
    private val _suggestions = MutableLiveData<MutableList<Suggestion>>()
    val suggestions: LiveData<MutableList<Suggestion>> = _suggestions
    init {
        _categories.value = mutableListOf(
            LocationCategory("겨울필수코스",R.drawable.ic_snowflake),
            LocationCategory("맛집",R.drawable.ic_dining),
            LocationCategory("카페",R.drawable.ic_cafe),
            LocationCategory("편의점",R.drawable.ic_convenience_store),
            LocationCategory("마트",R.drawable.ic_grocery_store)
        )

        _suggestions.value = mutableListOf(
            Suggestion(title = "부산 관광 명소", address = "부산광역시 연제구 연산동", category = "관광명소"),
            Suggestion(title = "부산 관광 명소", address = "부산광역시 연제구 연산동", category = "관광명소"),
            Suggestion(title = "부산 관광 명소", address = "부산광역시 연제구 연산동", category = "관광명소"),
            Suggestion(title = "부산 관광 명소", address = "부산광역시 연제구 연산동", category = "관광명소"),
            Suggestion(title = "부산 관광 명소", address = "부산광역시 연제구 연산동", category = "관광명소"),
            Suggestion(title = "부산 관광 명소", address = "부산광역시 연제구 연산동", category = "관광명소")
        )
    }
}