package com.eshc.travelplatform.domain.usecase.spot

import com.eshc.travelplatform.domain.model.SpotSuggestion
import com.eshc.travelplatform.domain.repository.SpotRepository

//class GetSpotSuggestionsUseCase(val spotRepository : SpotRepository): List<SpotSuggestion> {
//    suspend fun execute() = spotRepository.getSuggestions()
//}
class GetSpotSuggestionsUseCase(val spotRepository : SpotRepository){
}