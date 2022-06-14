package com.eshc.travelplatform.ui.recommend

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eshc.data.repository.ItineraryRepositoryImpl
import com.eshc.domain.model.Condition
import com.eshc.domain.usecase.itinerary.PostItineraryUseCase
import com.eshc.travelplatform.MainApplication

class RecommendViewModel : ViewModel() {
    private val _conditionWho = MutableLiveData<MutableList<Condition>>()
    val conditionWho: LiveData<MutableList<Condition>> = _conditionWho

    private val _conditionStyle = MutableLiveData<MutableList<Condition>>()
    val conditionStyle: LiveData<MutableList<Condition>> = _conditionStyle

    val itineraryRepositoryImpl = ItineraryRepositoryImpl(
        scheduleDataSource = MainApplication.getInstance().scheduleDataSource,
        dailyScheduleDataSource = MainApplication.getInstance().dailyScheduleDataSource
    )

    val postItinerariesUseCase = PostItineraryUseCase(itineraryRepositoryImpl)

    init {
        _conditionWho.value = mutableListOf(Condition("혼자",1),Condition("친구와",2),Condition("대충아마",3),Condition("두 줄",4))
        _conditionStyle.value = mutableListOf(Condition("익스트림",1),Condition("뭐가있지",2),Condition("먹거리",3),Condition("대충아마",4),
            Condition("세줄",1),Condition("휴식",2),Condition("많으면",3),Condition("네줄까지도",4)
        )
    }

    suspend fun postItinerary(title : String,startDate : String,endDate : String, description : String,period: Int) = postItinerariesUseCase(title,startDate,endDate,description,period)
}