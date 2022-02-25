package com.eshc.travelplatform.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "keep_table")
data class Keep (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    @ColumnInfo(name = "spot_id") var spotId : Int
)