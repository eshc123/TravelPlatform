package com.eshc.travelplatform.ui.mypage

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.travelplatform.MainApplication
import com.eshc.data.repository.SpotRepositoryImpl
import com.eshc.data.repository.UserRepositoryImpl
import com.eshc.domain.model.Spot
import com.eshc.domain.model.User
import com.eshc.domain.usecase.spot.GetKeepSpotsUseCase
import kotlinx.coroutines.launch

class MypageViewModel(userRepository: UserRepositoryImpl, spotRepositoryImpl: SpotRepositoryImpl) :
    ViewModel() {
    private val _user = MutableLiveData<User>()
    val user: LiveData<User> = _user
    private val _keepSpots = MutableLiveData<MutableList<Spot>>()
    val keepSpots: LiveData<MutableList<Spot>> = _keepSpots


    val getKeepSpotsUseCase = GetKeepSpotsUseCase(spotRepositoryImpl)

    init {
        _user.value = MainApplication.getInstance().user
        viewModelScope.launch {
            _keepSpots.value = getKeepSpots().toMutableList()
        }

    }

    suspend fun getKeepSpots() = getKeepSpotsUseCase()
}