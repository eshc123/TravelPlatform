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
            Suggestion(title = "부산시청", address = "부산광역시 연제구", category = "관공서",point = Pair(35.179792, 129.074881)),
            Suggestion(title = "광안리 해수욕장", address = "부산광역시 수영구", category = "관광명소",point = Pair(35.153659, 129.118537)),
            Suggestion(title = "해운대 해수욕장", address = "부산광역시 해운대구", category = "관광명소",point = Pair(35.158837, 129.160255)),
            Suggestion(title = "기장 용궁사", address = "부산광역시 기장군", category = "관광명소",point = Pair(35.188471, 129.223319)),
            Suggestion(title = "영화의 전당", address = "부산광역시 해운대구", category = "영화관",point = Pair(35.171283, 129.127217)),
            Suggestion(title = "다대포 해수욕장", address = "부산광역시 사하구", category = "관광명소",point = Pair(35.047251, 128.966281))
        )
    }
}