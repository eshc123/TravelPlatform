package com.eshc.domain.usecase.itinerary

import com.eshc.domain.repository.ItineraryRepository

class PostItineraryUseCase(val itineraryRepository: ItineraryRepository){
    suspend operator fun invoke(title : String,startDate : String,endDate : String, description : String,period: Int){
        itineraryRepository.postItinerary(title,startDate,endDate, description,period )
    }
}