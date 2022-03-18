package com.eshc.travelplatform.ui.plan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.travelplatform.data.repository.SpotRepositoryImpl
import com.eshc.travelplatform.domain.model.Spot
import com.eshc.travelplatform.domain.usecase.spot.DeleteKeepSpotUseCase
import com.eshc.travelplatform.domain.usecase.spot.GetSpotUseCase
import com.eshc.travelplatform.domain.usecase.spot.PostKeepSpotUseCase
import kotlinx.coroutines.launch

class SearchDetailViewModel(spotRepositoryImpl: SpotRepositoryImpl,id: Int) : ViewModel() {
    private val _searchSpot = MutableLiveData<Spot>()
    val searchSpot: LiveData<Spot> = _searchSpot

    private val postKeepSpot = PostKeepSpotUseCase(spotRepositoryImpl)
    private val getSpot = GetSpotUseCase(spotRepositoryImpl)
    private val deleteKeepSpot = DeleteKeepSpotUseCase(spotRepositoryImpl)
    init {
        viewModelScope.launch {
            getSearchSpot(id)
        }
    }

    suspend fun postKeep(spot: Spot) = postKeepSpot(spot)
    suspend fun deleteKeep(spot: Spot) = deleteKeepSpot(spot)

    suspend fun getSearchSpot(id : Int) {
        _searchSpot.value = getSpot(id) ?: null
    }
}