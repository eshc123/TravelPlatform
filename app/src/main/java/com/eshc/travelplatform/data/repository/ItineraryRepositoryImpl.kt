package com.eshc.travelplatform.data.repository

import com.eshc.travelplatform.data.local.DailyScheduleLocalDataSource
import com.eshc.travelplatform.data.local.ScheduleLocalDataSource
import com.eshc.travelplatform.domain.repository.ItineraryRepository

class ItineraryRepositoryImpl(val scheduleDataSource: ScheduleLocalDataSource,val dailyScheduleDataSource : DailyScheduleLocalDataSource) : ItineraryRepository {
    override suspend fun getItinerary() {

    }

    override suspend fun postItinerary(startData : String,endDate : String, description : String) {
        scheduleDataSource.postSchedule(startData, endDate, description)
    }

    override suspend fun putItinerary() {

    }

}