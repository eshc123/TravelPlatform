package com.eshc.travelplatform.data.local

import com.eshc.travelplatform.data.local.db.dao.CourseDao
import com.eshc.travelplatform.data.local.db.entity.CourseEntity


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