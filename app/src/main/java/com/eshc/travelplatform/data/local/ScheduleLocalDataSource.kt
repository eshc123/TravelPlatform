package com.eshc.travelplatform.data.local

import com.eshc.travelplatform.data.local.db.dao.ScheduleDao
import com.eshc.travelplatform.data.local.db.entity.ScheduleEntity
import com.eshc.travelplatform.domain.model.Itinerary

class ScheduleLocalDataSource (
    private val scheduleDao : ScheduleDao
){
    suspend fun postSchedule(title : String,startData : String,endDate : String, description : String){
        scheduleDao.postSchedule(
            schedule = ScheduleEntity(
                title = title,
                startDate = startData,
                endDate = endDate,
                description = description
            )
        )
    }

    suspend fun getSchedule() : List<Itinerary> {
        return scheduleDao.getSchedules().toItinerary()
    }
}
fun List<ScheduleEntity>.toItinerary() : List<Itinerary>{
    return this.map {
        Itinerary(
            startDate = it.startDate,
            endDate = it.endDate,
            description = it.description,
            title = it.title
        )
    }
}