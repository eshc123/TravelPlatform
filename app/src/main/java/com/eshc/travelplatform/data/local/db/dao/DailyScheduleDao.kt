package com.eshc.travelplatform.data.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.eshc.travelplatform.data.local.db.entity.DailySchedule
import kotlinx.coroutines.flow.Flow

@Dao
interface DailyScheduleDao {
    @Query("SELECT * FROM daily_schedule_table")
    fun getDailySchedules() : Flow<List<DailySchedule>>
}