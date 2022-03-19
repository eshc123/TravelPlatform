package com.eshc.travelplatform.domain.usecase.itinerary

import com.eshc.travelplatform.domain.model.Itinerary
import com.eshc.travelplatform.domain.repository.ItineraryRepository

class GetItinerariesUseCase (val itineraryRepository: ItineraryRepository){
    suspend operator fun invoke() :  List<Itinerary> {
        return itineraryRepository.getItinerary( )
    }
}