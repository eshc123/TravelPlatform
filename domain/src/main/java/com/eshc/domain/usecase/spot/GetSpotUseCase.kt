package com.eshc.domain.usecase.spot

import com.eshc.domain.model.Spot
import com.eshc.domain.repository.SpotRepository


class GetSpotUseCase(val spotRepository : SpotRepository){
    suspend operator fun invoke(id : Int): Spot{
        return spotRepository.getSpot(id)
    }
}