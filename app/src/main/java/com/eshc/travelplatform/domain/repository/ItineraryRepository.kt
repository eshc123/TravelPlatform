package com.eshc.travelplatform.domain.repository

interface ItineraryRepository {
    suspend fun getItinerary()

    suspend fun postItinerary(startData : String,endDate : String, description : String)

    suspend fun putItinerary()
}