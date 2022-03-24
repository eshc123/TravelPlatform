package com.eshc.travelplatform.domain.usecase.course

import com.eshc.travelplatform.domain.repository.CourseRepository

class PostCoursesUseCase (val courseRepository: CourseRepository){
    suspend operator fun invoke(dailyScheduleId : Int,order : Int,spotId: Int)  {
        return courseRepository.postCourse(dailyScheduleId, order, spotId )
    }
}