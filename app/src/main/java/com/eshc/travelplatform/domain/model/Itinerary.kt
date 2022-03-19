package com.eshc.travelplatform.domain.model

data class Itinerary(val title : String,val description : String, val startDate : String,val endDate : String, val schedules : List<Course>? = listOf(Course("","")))