package com.eshc.travelplatform.data.repository

import com.eshc.travelplatform.data.local.DailyScheduleLocalDataSource
import com.eshc.travelplatform.data.local.ScheduleLocalDataSource
import com.eshc.domain.model.Course
import com.eshc.domain.model.Itinerary
import com.eshc.domain.repository.ItineraryRepository

class ItineraryRepositoryImpl(val scheduleDataSource: ScheduleLocalDataSource,val dailyScheduleDataSource : DailyScheduleLocalDataSource) : ItineraryRepository {
    override suspend fun getItinerary() : List<Itinerary> {
        val schedules = scheduleDataSource.getSchedule()
        //daily Schedule 없을 시
        schedules.forEach {
            for(i in 1 .. it.period){
                it.schedules?.add(Course("",""))
            }
        }
        return schedules
    }

    override suspend fun postItinerary(title : String,startDate : String,endDate : String, description : String,period: Int) {
        scheduleDataSource.postSchedule(title,startDate, endDate, description,period)
    }

    override suspend fun putItinerary() {

    }

}