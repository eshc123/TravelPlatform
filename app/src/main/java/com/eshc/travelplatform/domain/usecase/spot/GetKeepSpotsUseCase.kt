package com.eshc.travelplatform.domain.usecase.spot

import com.eshc.travelplatform.domain.model.Spot
import com.eshc.travelplatform.domain.repository.SpotRepository

class GetKeepSpotsUseCase (val spotRepository : SpotRepository) {
    suspend operator fun invoke(): List<Spot> {
        return spotRepository.getKeepSpots()
    }
}