package com.eshc.travelplatform.domain.repository

interface CourseRepository {

    suspend fun postCourse(dailyScheduleId : Int,order : Int,spotId: Int)

}