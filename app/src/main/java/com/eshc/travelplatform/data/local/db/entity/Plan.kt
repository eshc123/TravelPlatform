package com.eshc.travelplatform.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "plan_table")
data class Plan(
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo(name = "start_date") val startDate : String,
    @ColumnInfo(name = "end_date") val endDate : String,
    val description : String
)
