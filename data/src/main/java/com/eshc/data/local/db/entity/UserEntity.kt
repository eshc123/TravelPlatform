package com.eshc.data.local.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class UserEntity (
    @PrimaryKey(autoGenerate = true) val id : Int = 0,
    var userId : String,
    var password : String,
    @ColumnInfo(name = "phone_num") var phoneNum : String
)