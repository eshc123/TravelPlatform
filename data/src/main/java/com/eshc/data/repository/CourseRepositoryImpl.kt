package com.eshc.data.repository

import com.eshc.data.local.datasource.CourseLocalDataSource
import com.eshc.data.local.datasourceImpl.CourseLocalDataSourceImpl
import com.eshc.domain.repository.CourseRepository

class CourseRepositoryImpl(val courseLocalDataSourceImpl: CourseLocalDataSourceImpl) : CourseRepository {


   override suspend fun postCourse(dailyScheduleId: Int, order: Int, spotId: Int) {
      courseLocalDataSourceImpl.postCourse(dailyScheduleId, order, spotId)
   }


}