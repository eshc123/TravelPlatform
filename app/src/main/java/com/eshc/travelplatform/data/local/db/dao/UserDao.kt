package com.eshc.travelplatform.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eshc.travelplatform.data.local.db.entity.Course
import com.eshc.travelplatform.data.local.db.entity.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: User)

    @Query("SELECT * FROM user_table")
    fun getUsers() : Flow<List<User>>

    @Query("SELECT password FROM user_table WHERE userId LIKE :id")
    fun getPassword(id : String) : Flow<String>
}