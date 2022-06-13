package com.eshc.travelplatform.ui.plan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.travelplatform.MainApplication
import com.eshc.data.repository.SpotRepositoryLocalImpl
import com.eshc.domain.model.Itinerary
import com.eshc.domain.model.Spot
import com.eshc.domain.model.User
import com.eshc.domain.usecase.spot.GetKeepSpotsUseCase
import kotlinx.coroutines.launch

class MyscheduleViewModel() :
    ViewModel() {

    private val _itineraries = MutableLiveData<MutableList<Itinerary>>()
    val itineraries: LiveData<MutableList<Itinerary>> = _itineraries

    init {
        _itineraries.postValue(
            mutableListOf(
                Itinerary("테스트1","테스트1","테스트","테스트",1),
                Itinerary("테스트2","테스트2","테스트","테스트",2),
                Itinerary("테스트3","테스트3","테스트","테스트",3),
                Itinerary("테스트4","테스트4","테스트","테스트",4))
        )
    }
}