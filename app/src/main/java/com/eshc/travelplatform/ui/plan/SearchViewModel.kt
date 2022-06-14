package com.eshc.travelplatform.ui.plan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.travelplatform.R
import com.eshc.data.repository.SpotRepositoryLocalImpl
import com.eshc.domain.model.LocationCategory
import com.eshc.domain.model.Spot
import com.eshc.domain.usecase.spot.DeleteKeepSpotUseCase
import com.eshc.domain.usecase.spot.GetSpotSuggestionsUseCase
import com.eshc.domain.usecase.spot.GetSpotUseCase
import com.eshc.domain.usecase.spot.PostKeepSpotUseCase
import com.eshc.travelplatform.MainApplication
import kotlinx.coroutines.launch

class SearchViewModel : ViewModel() {
    private val _categories = MutableLiveData<MutableList<LocationCategory>>()
    val categories: LiveData<MutableList<LocationCategory>> = _categories
    private val _suggestions = MutableLiveData<MutableList<Spot>>()
    val suggestions: LiveData<MutableList<Spot>> = _suggestions
    private val _searchSpot = MutableLiveData<Spot>()
    val searchSpot: LiveData<Spot> = _searchSpot

    val spotRepositoryLocalImpl = SpotRepositoryLocalImpl(
        spotDataSource = MainApplication.getInstance().spotLocalDataSource,
        keepDataSource = MainApplication.getInstance().keepLocalDataSource
    )

    val getSpotSuggestions = GetSpotSuggestionsUseCase(spotRepositoryLocalImpl)

    private val postKeepSpot = PostKeepSpotUseCase(spotRepositoryLocalImpl)
    private val getSpot = GetSpotUseCase(spotRepositoryLocalImpl)
    private val deleteKeepSpot = DeleteKeepSpotUseCase(spotRepositoryLocalImpl)

    init {
        _categories.value = mutableListOf(
            LocationCategory("겨울필수코스",R.drawable.ic_snowflake),
            LocationCategory("맛집",R.drawable.ic_dining),
            LocationCategory("카페",R.drawable.ic_cafe),
            LocationCategory("편의점",R.drawable.ic_convenience_store),
            LocationCategory("마트",R.drawable.ic_grocery_store)
        )
        viewModelScope.launch {
            _suggestions.value = getSpotSuggestions().toMutableList()
        }
    }

    suspend fun postKeep(spot: Spot) = postKeepSpot(spot)
    suspend fun deleteKeep(spot: Spot) = deleteKeepSpot(spot)

    suspend fun getSearchSpot(id : Int) {
        _searchSpot.value = getSpot(id) ?: null
    }

}