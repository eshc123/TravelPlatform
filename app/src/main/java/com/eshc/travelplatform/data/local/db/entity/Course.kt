package com.eshc.travelplatform.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course_table")
data class Course (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo(name = "daily_plan_id") var dailyPlanId : Int,
    @ColumnInfo(name = "spot_id") var spotId : Int,
    var order : Int
)