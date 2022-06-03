package com.eshc.data.local.datasource

import com.eshc.data.local.db.dao.CourseDao
import com.eshc.data.local.db.entity.CourseEntity


interface CourseLocalDataSource {
    suspend fun postCourse(dailyScheduleId: Int, order: Int, spotId: Int)
}