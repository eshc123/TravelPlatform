package com.eshc.travelplatform.ui.recommend

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eshc.travelplatform.MainApplication
import com.eshc.data.repository.ItineraryRepositoryImpl

class RecommendViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RecommendViewModel::class.java)) {
            return RecommendViewModel(
                itineraryRepositoryImpl = ItineraryRepositoryImpl(
                    scheduleDataSource = MainApplication.getInstance().scheduleDataSource,
                    dailyScheduleDataSource = MainApplication.getInstance().dailyScheduleDataSource
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}