package com.eshc.domain.usecase.spot

import com.eshc.domain.model.Spot
import com.eshc.domain.repository.SpotRepository

class GetPopularSpotsUseCase(val spotRepository : SpotRepository){
    suspend operator fun invoke(): List<Spot>{
        return spotRepository.getPopularSpots()
    }
}