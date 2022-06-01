package com.eshc.data.local.datasourceImpl

import com.eshc.data.local.datasource.CourseLocalDataSource
import com.eshc.data.local.db.dao.CourseDao
import com.eshc.data.local.db.entity.CourseEntity
import javax.inject.Inject


class CourseLocalDataSourceImpl @Inject constructor(
    private val courseDao : CourseDao
) : CourseLocalDataSource{

    override suspend fun postCourse(dailyScheduleId: Int, order: Int, spotId: Int){
        courseDao.insertCourse(courseEntity = CourseEntity(
            dailyScheduleId = dailyScheduleId,
            order = order,
            spotId = spotId,
        ))
    }
}