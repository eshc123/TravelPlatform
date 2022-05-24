package com.eshc.domain.usecase.course

import com.eshc.domain.repository.CourseRepository

class PostCoursesUseCase (val courseRepository: CourseRepository){
    suspend operator fun invoke(dailyScheduleId : Int,order : Int,spotId: Int)  {
        return courseRepository.postCourse(dailyScheduleId, order, spotId )
    }
}