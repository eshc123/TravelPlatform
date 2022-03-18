package com.eshc.travelplatform.ui.plan

import androidx.databinding.Observable
import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.travelplatform.R
import com.eshc.travelplatform.data.repository.SpotRepositoryImpl
import com.eshc.travelplatform.domain.model.LocationCategory
import com.eshc.travelplatform.domain.model.Spot
import com.eshc.travelplatform.domain.usecase.spot.GetSpotSuggestionsUseCase
import com.eshc.travelplatform.domain.usecase.spot.GetSpotUseCase
import com.eshc.travelplatform.domain.usecase.spot.PostKeepSpotUseCase
import kotlinx.coroutines.launch

class SearchDetailViewModel(spotRepositoryImpl: SpotRepositoryImpl,id: Int) : ViewModel() {
    private val _searchSpot = MutableLiveData<Spot>()
    val searchSpot: LiveData<Spot> = _searchSpot

    val postKeepSpot = PostKeepSpotUseCase(spotRepositoryImpl)
    val getSpot = GetSpotUseCase(spotRepositoryImpl)

    init {
        viewModelScope.launch {
            _searchSpot.value = getSearchSpot(id)
        }
    }

    suspend fun postKeep(spot: Spot) = postKeepSpot(spot)
    suspend fun deleteKeep(spot: Spot) = postKeepSpot(spot)

    private suspend fun getSearchSpot(id : Int) : Spot = getSpot(id)
}