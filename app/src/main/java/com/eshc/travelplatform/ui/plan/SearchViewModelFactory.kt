package com.eshc.travelplatform.ui.plan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eshc.travelplatform.MainApplication
import com.eshc.travelplatform.data.repository.SpotRepositoryImpl
import com.eshc.travelplatform.data.repository.UserRepositoryImpl

class SearchViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchViewModel::class.java)) {
            return SearchViewModel(
                spotRepositoryImpl = SpotRepositoryImpl(
                    dataSource = MainApplication.getInstance().spotLocalDataSource
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}