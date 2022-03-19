package com.eshc.travelplatform.domain.usecase.itinerary

import com.eshc.travelplatform.domain.repository.ItineraryRepository

class PostItineraryUseCase(val itineraryRepository: ItineraryRepository){
    suspend operator fun invoke(title : String,startData : String,endDate : String, description : String){
        itineraryRepository.postItinerary(title,startData,endDate, description )
    }
}