package com.eshc.domain.repository

import com.eshc.domain.model.Itinerary

interface ItineraryRepository {
    suspend fun getItinerary() : List<Itinerary>

    suspend fun postItinerary(title : String,startDate : String,endDate : String, description : String,period: Int)

    suspend fun putItinerary()
}