package com.eshc.travelplatform.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location_category_table")
data class LocationCategoryEntity (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val title : String,
    val image : Int
)
