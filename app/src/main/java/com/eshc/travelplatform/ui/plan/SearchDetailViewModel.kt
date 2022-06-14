package com.eshc.travelplatform.ui.plan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.data.repository.SpotRepositoryLocalImpl
import com.eshc.domain.model.Spot
import com.eshc.domain.usecase.spot.DeleteKeepSpotUseCase
import com.eshc.domain.usecase.spot.GetSpotUseCase
import com.eshc.domain.usecase.spot.PostKeepSpotUseCase
import kotlinx.coroutines.launch

class SearchDetailViewModel(spotRepositoryLocalImpl: SpotRepositoryLocalImpl, id: Int) : ViewModel() {
    private val _searchSpot = MutableLiveData<Spot>()
    val searchSpot: LiveData<Spot> = _searchSpot

    private val postKeepSpot = PostKeepSpotUseCase(spotRepositoryLocalImpl)
    private val getSpot = GetSpotUseCase(spotRepositoryLocalImpl)
    private val deleteKeepSpot = DeleteKeepSpotUseCase(spotRepositoryLocalImpl)
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