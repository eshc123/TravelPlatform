package com.eshc.travelplatform.domain.usecase.spot

import com.eshc.travelplatform.domain.model.Spot
import com.eshc.travelplatform.domain.repository.SpotRepository


class GetSpotUseCase(val spotRepository : SpotRepository){
    suspend operator fun invoke(id : Int): Spot{
        return spotRepository.getSpot(id)
    }
}