package com.eshc.travelplatform.ui.plan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eshc.travelplatform.MainApplication
import com.eshc.travelplatform.data.repository.SpotRepositoryImpl

class PlanViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlanViewModel::class.java)) {
            return PlanViewModel(
                spotRepositoryImpl = SpotRepositoryImpl(
                    spotDataSource = MainApplication.getInstance().spotLocalDataSource,
                    keepDataSource = MainApplication.getInstance().keepLocalDataSource
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}