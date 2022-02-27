package com.eshc.travelplatform.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "daily_schedule_table")
data class DailySchedule(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val day : Int,
    val description : String
)
