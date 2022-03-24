package com.eshc.travelplatform.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eshc.travelplatform.data.local.db.entity.CourseEntity
import com.eshc.travelplatform.data.local.db.entity.KeepEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CourseDao {
    @Query("SELECT * FROM course_table")
    fun getCourses() : Flow<List<CourseEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCourse(courseEntity: CourseEntity)
}