package com.eshc.domain.usecase.itinerary

import com.eshc.domain.model.Itinerary
import com.eshc.domain.repository.ItineraryRepository

class GetItinerariesUseCase (val itineraryRepository: ItineraryRepository){
    suspend operator fun invoke() :  List<Itinerary> {
        return itineraryRepository.getItinerary( )
    }
}