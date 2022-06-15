package com.eshc.travelplatform.ui.plan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.data.repository.ItineraryRepositoryImpl
import com.eshc.data.repository.SpotRepositoryLocalImpl
import com.eshc.domain.model.Course
import com.eshc.domain.model.Itinerary
import com.eshc.domain.model.Spot
import com.eshc.domain.usecase.itinerary.GetItinerariesUseCase
import com.eshc.domain.usecase.spot.GetPopularSpotsUseCase
import com.eshc.travelplatform.MainApplication
import kotlinx.coroutines.launch

class PlanDetailViewModel: ViewModel() {

    val itineraryRepositoryImpl = ItineraryRepositoryImpl(
        scheduleDataSource = MainApplication.getInstance().scheduleDataSource,
        dailyScheduleDataSource = MainApplication.getInstance().dailyScheduleDataSource
    )



    private val _itineraries = MutableLiveData<MutableList<Itinerary>>()
    val itineraries: LiveData<MutableList<Itinerary>> = _itineraries

    val getItineraryUseCase = GetItinerariesUseCase(itineraryRepositoryImpl)




    init {
        viewModelScope.launch {
            _itineraries.value = getItineraryUseCase().toMutableList()

        }


    }
}