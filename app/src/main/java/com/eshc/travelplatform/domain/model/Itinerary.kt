package com.eshc.travelplatform.domain.model

data class Itinerary(val title : String,val description : String, val startDate : String,val endDate : String,val period : Int, var schedules : MutableList<Course>? = mutableListOf())