package com.eshc.travelplatform.domain.usecase.itinerary

import com.eshc.travelplatform.domain.repository.ItineraryRepository

class PostItineraryUseCase(val itineraryRepository: ItineraryRepository){
    suspend operator fun invoke(startData : String,endDate : String, description : String){
        itineraryRepository.postItinerary(startData,endDate, description )
    }
}