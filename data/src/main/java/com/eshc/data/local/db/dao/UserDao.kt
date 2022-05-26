package com.eshc.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eshc.data.local.db.entity.UserEntity

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(userEntity: UserEntity)

    @Query("SELECT * FROM user_table WHERE userId == :id")
    suspend fun getUserById(id: String) : UserEntity

    @Query("SELECT password FROM user_table WHERE userId LIKE :id")
    suspend fun getPassword(id : String) : String
}