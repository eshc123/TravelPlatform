package com.eshc.travelplatform.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course_table")
data class CourseEntity (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo(name = "daily_schedule_id") var dailyScheduleId : Int,
    @ColumnInfo(name = "spot_id") var spotId : Int,
    var order : Int
)