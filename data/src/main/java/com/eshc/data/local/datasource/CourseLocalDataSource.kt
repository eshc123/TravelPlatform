package com.eshc.data.local.datasource

import com.eshc.data.local.db.dao.CourseDao
import com.eshc.data.local.db.entity.CourseEntity


class CourseLocalDataSource (
    private val courseDao : CourseDao
){
    suspend fun postCourse(dailyScheduleId: Int, order: Int, spotId: Int){
        courseDao.insertCourse(courseEntity = CourseEntity(
            dailyScheduleId = dailyScheduleId,
            order = order,
            spotId = spotId,
        ))
    }
}