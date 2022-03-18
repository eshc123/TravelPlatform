package com.eshc.travelplatform.data.local

import com.eshc.travelplatform.data.local.db.dao.ScheduleDao
import com.eshc.travelplatform.data.local.db.entity.ScheduleEntity

class ScheduleLocalDataSource (
    private val scheduleDao : ScheduleDao
){
    suspend fun postSchedule(startData : String,endDate : String, description : String){
        scheduleDao.postSchedule(
            schedule = ScheduleEntity(
                startDate = startData,
                endDate = endDate,
                description = description
            )
        )
    }
}