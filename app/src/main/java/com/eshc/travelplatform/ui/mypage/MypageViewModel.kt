package com.eshc.travelplatform.ui.mypage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eshc.travelplatform.MainApplication
import com.eshc.travelplatform.data.repository.UserRepositoryImpl
import com.eshc.travelplatform.domain.model.Spot
import com.eshc.travelplatform.domain.model.User

class MypageViewModel(userRepository : UserRepositoryImpl) : ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user

    init {
        _user.value = MainApplication.getInstance().user
    }
}