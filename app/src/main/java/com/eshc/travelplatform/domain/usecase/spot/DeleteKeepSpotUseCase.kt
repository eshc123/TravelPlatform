package com.eshc.travelplatform.domain.usecase.spot

import com.eshc.travelplatform.domain.model.Spot
import com.eshc.travelplatform.domain.repository.SpotRepository

class DeleteKeepSpotUseCase (val spotRepository : SpotRepository){
    suspend operator fun invoke(spot: Spot){
        spotRepository.deleteKeep(spot)
    }
}