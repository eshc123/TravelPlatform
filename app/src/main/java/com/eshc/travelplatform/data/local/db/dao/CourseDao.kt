package com.eshc.travelplatform.data.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.eshc.travelplatform.data.local.db.entity.CourseEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {
    @Query("SELECT * FROM course_table")
    fun getCourses() : Flow<List<CourseEntity>>
}