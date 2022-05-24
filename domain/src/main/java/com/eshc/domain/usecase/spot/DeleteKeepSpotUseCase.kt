package com.eshc.domain.usecase.spot

import com.eshc.domain.model.Spot
import com.eshc.domain.repository.SpotRepository

class DeleteKeepSpotUseCase (val spotRepository : SpotRepository){
    suspend operator fun invoke(spot: Spot){
        spotRepository.deleteKeep(spot)
    }
}