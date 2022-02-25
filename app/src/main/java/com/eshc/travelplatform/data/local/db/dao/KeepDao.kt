package com.eshc.travelplatform.data.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.eshc.travelplatform.data.local.db.entity.Course
import com.eshc.travelplatform.data.local.db.entity.Keep
import kotlinx.coroutines.flow.Flow

@Dao
interface KeepDao {
    @Query("SELECT * FROM keep_table")
    fun getKeeps() : Flow<List<Keep>>
}