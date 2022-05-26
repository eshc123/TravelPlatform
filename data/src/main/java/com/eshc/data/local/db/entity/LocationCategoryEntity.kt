package com.eshc.data.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "location_category_table")
data class LocationCategoryEntity (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val title : String,
    val image : Int
)
