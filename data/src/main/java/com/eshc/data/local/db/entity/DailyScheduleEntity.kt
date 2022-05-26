package com.eshc.data.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_schedule_table")
data class DailyScheduleEntity(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val day : Int,
    val description : String
)
