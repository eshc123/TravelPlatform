package com.eshc.travelplatform.data.repository

import com.eshc.travelplatform.data.local.CourseLocalDataSource
import com.eshc.travelplatform.data.local.KeepLocalDataSource
import com.eshc.travelplatform.data.local.LocationCategoryLocalDataSource
import com.eshc.travelplatform.data.local.SpotLocalDataSource
import com.eshc.travelplatform.domain.model.Spot
import com.eshc.travelplatform.domain.repository.CourseRepository
import com.eshc.travelplatform.domain.repository.LocationCategoryRepository
import com.eshc.travelplatform.domain.repository.SpotRepository
import kotlinx.coroutines.flow.first

class CourseRepositoryImpl(val courseLocalDataSource: CourseLocalDataSource) : CourseRepository {


   override suspend fun postCourse(dailyScheduleId: Int, order: Int, spotId: Int) {
      courseLocalDataSource.postCourse(dailyScheduleId, order, spotId)
   }


}