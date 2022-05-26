package com.eshc.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eshc.data.local.db.entity.ScheduleEntity

@Dao
interface ScheduleDao {
    @Query("SELECT * FROM schedule_table")
    suspend fun getSchedules() : List<ScheduleEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun postSchedule(schedule : ScheduleEntity)
}