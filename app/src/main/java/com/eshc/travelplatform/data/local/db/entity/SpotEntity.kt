package com.eshc.travelplatform.data.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "spot_table")
data class SpotEntity (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val name : String,
    val address : String,
    val category : String,
    val x : Double,
    val y : Double,
    val image : String
)