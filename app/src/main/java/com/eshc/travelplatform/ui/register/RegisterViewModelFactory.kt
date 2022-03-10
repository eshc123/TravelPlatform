package com.eshc.travelplatform.ui.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.eshc.travelplatform.MainApplication
import com.eshc.travelplatform.data.repository.UserRepositoryImpl

class RegisterViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(
                userRepositoryImpl = UserRepositoryImpl(
                    dataSource = MainApplication.getInstance().userLocalDataSource
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}