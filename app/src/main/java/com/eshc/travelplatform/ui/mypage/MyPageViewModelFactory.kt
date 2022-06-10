package com.eshc.travelplatform.ui.mypage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eshc.travelplatform.MainApplication
import com.eshc.data.repository.SpotRepositoryLocalImpl

class MyPageViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MypageViewModel::class.java)) {
            return MypageViewModel(
                spotRepositoryLocalImpl = SpotRepositoryLocalImpl(
                    MainApplication.getInstance().spotLocalDataSource,
                    MainApplication.getInstance().keepLocalDataSource
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}