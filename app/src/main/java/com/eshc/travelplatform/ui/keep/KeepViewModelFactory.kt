package com.eshc.travelplatform.ui.keep

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eshc.travelplatform.MainApplication
import com.eshc.data.repository.SpotRepositoryImpl

class KeepViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(KeepViewModel::class.java)) {
            return KeepViewModel(
                SpotRepositoryImpl(
                    spotDataSource = MainApplication.getInstance().spotLocalDataSource,
                    keepDataSource = MainApplication.getInstance().keepLocalDataSource
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}