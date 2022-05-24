package com.eshc.domain.repository

interface CourseRepository {

    suspend fun postCourse(dailyScheduleId : Int,order : Int,spotId: Int)

}