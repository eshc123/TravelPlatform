package com.eshc.travelplatform.data.local.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "course_table")
data class Course (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,

)