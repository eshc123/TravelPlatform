package com.eshc.travelplatform.domain.usecase.spot

import com.eshc.travelplatform.domain.model.Spot
import com.eshc.travelplatform.domain.repository.SpotRepository

class GetKeepSpotByIdUseCase (val spotRepository : SpotRepository) {
    suspend operator fun invoke(id:Int): List<Spot> {
        return spotRepository.getKeepSpotById(id)
    }
}