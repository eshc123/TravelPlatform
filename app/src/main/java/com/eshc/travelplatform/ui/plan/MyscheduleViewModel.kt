package com.eshc.travelplatform.ui.plan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eshc.travelplatform.MainApplication
import com.eshc.data.repository.SpotRepositoryLocalImpl
import com.eshc.domain.model.Spot
import com.eshc.domain.model.User
import com.eshc.domain.usecase.spot.GetKeepSpotsUseCase
import kotlinx.coroutines.launch

class MyscheduleViewModel() :
    ViewModel() {

}