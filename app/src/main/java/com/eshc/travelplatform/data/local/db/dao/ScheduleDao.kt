package com.eshc.travelplatform.data.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.eshc.travelplatform.data.local.db.entity.Schedule
import kotlinx.coroutines.flow.Flow

@Dao
interface ScheduleDao {
    @Query("SELECT * FROM schedule_table")
    fun getSchedules() : Flow<List<Schedule>>
}