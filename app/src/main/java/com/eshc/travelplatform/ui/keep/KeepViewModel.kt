package com.eshc.travelplatform.ui.keep

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.data.repository.SpotRepositoryLocalImpl
import com.eshc.domain.model.Spot
import com.eshc.domain.usecase.spot.GetKeepSpotsUseCase
import com.eshc.travelplatform.MainApplication
import kotlinx.coroutines.launch

class KeepViewModel() : ViewModel() {
    private val _keepSpots = MutableLiveData<MutableList<Spot>>()
    val keepSpots: LiveData<MutableList<Spot>> = _keepSpots

    val spotRepositoryLocalImpl = SpotRepositoryLocalImpl(MainApplication.getInstance().spotLocalDataSource,
    MainApplication.getInstance().keepLocalDataSource)

    val getKeepSpotsUseCase = GetKeepSpotsUseCase(spotRepositoryLocalImpl)
    init {
        viewModelScope.launch {
            _keepSpots.value = getKeepSpotsUseCase().toMutableList()
        }
    }

}