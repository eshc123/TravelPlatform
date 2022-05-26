package com.eshc.data.repository

import com.eshc.data.local.CourseLocalDataSource
import com.eshc.domain.repository.CourseRepository

class CourseRepositoryImpl(val courseLocalDataSource: CourseLocalDataSource) : CourseRepository {


   override suspend fun postCourse(dailyScheduleId: Int, order: Int, spotId: Int) {
      courseLocalDataSource.postCourse(dailyScheduleId, order, spotId)
   }


}