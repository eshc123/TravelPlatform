package com.eshc.travelplatform.ui.keep

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.travelplatform.data.repository.SpotRepositoryImpl
import com.eshc.travelplatform.domain.model.Spot
import com.eshc.travelplatform.domain.usecase.spot.GetKeepSpotsUseCase
import kotlinx.coroutines.launch

class KeepViewModel(spotRepositoryImpl: SpotRepositoryImpl) : ViewModel() {
    private val _keepSpots = MutableLiveData<MutableList<Spot>>()
    val keepSpots: LiveData<MutableList<Spot>> = _keepSpots

    val getKeepSpotsUseCase = GetKeepSpotsUseCase(spotRepositoryImpl)
    init {
        viewModelScope.launch {
            _keepSpots.value = getKeepSpotsUseCase().toMutableList()
        }
    }

}