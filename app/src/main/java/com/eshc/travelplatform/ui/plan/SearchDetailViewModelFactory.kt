package com.eshc.travelplatform.ui.plan

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eshc.travelplatform.MainApplication
import com.eshc.data.repository.SpotRepositoryLocalImpl

class SearchDetailViewModelFactory(val id : Int) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SearchDetailViewModel::class.java)) {
            return SearchDetailViewModel(
                spotRepositoryLocalImpl = SpotRepositoryLocalImpl(
                    spotDataSource = MainApplication.getInstance().spotLocalDataSource,
                    keepDataSource = MainApplication.getInstance().keepLocalDataSource
                ),id
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}