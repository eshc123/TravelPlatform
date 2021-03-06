package com.eshc.data.local.datasource

import com.eshc.data.local.db.dao.ScheduleDao
import com.eshc.data.local.db.entity.ScheduleEntity
import com.eshc.domain.model.Itinerary

class ScheduleLocalDataSource (
    private val scheduleDao : ScheduleDao
){
    suspend fun postSchedule(title : String,startDate : String,endDate : String, description : String,period: Int){
        scheduleDao.postSchedule(
            schedule = ScheduleEntity(
                title = title,
                startDate = startDate,
                endDate = endDate,
                description = description,
                period = period
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
            title = it.title,
            period = it.period
        )
    }
}