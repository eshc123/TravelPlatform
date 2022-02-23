package com.eshc.travelplatform.data.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "keep_table")
data class Keep (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    val name : String,
    val address : String,
    val image : String
)