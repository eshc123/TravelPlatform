package com.eshc.travelplatform.ui.plan

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eshc.travelplatform.domain.model.Spot

class PlanViewModel : ViewModel() {
    private val _spots = MutableLiveData<MutableList<Spot>>()
    val spots: LiveData<MutableList<Spot>> = _spots
    init {
        _spots.value = mutableListOf( Spot("서면",35.157529, 129.059315),
            Spot("광안대교",35.132803, 129.108314),
            Spot("해운대역",35.164039, 129.158778))
    }
    fun deleteSpot(idx:Int){
        _spots.value?.removeAt(idx)
        _spots.value = _spots.value
    }
}