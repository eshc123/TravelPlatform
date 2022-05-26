package com.eshc.data.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.eshc.data.local.db.entity.DailyScheduleEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DailyScheduleDao {
    @Query("SELECT * FROM daily_schedule_table")
    fun getDailySchedules() : Flow<List<DailyScheduleEntity>>
}