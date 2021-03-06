package com.eshc.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "schedule_table")
data class ScheduleEntity(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val title : String,
    @ColumnInfo(name = "start_date") val startDate : String,
    @ColumnInfo(name = "end_date") val endDate : String,
    val description : String,
    val period : Int
)
