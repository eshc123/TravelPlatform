package com.eshc.travelplatform.ui.plan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eshc.travelplatform.MainApplication
import com.eshc.data.repository.ItineraryRepositoryImpl
import com.eshc.data.repository.SpotRepositoryLocalImpl

class PlanViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlanViewModel::class.java)) {
            return PlanViewModel(
                spotRepositoryLocalImpl = SpotRepositoryLocalImpl(
                    spotDataSource = MainApplication.getInstance().spotLocalDataSource,
                    keepDataSource = MainApplication.getInstance().keepLocalDataSource
                ),
                itineraryRepositoryImpl = ItineraryRepositoryImpl(
                    scheduleDataSource = MainApplication.getInstance().scheduleDataSource,
                    dailyScheduleDataSource = MainApplication.getInstance().dailyScheduleDataSource
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}