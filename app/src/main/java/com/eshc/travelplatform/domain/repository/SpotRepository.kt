package com.eshc.travelplatform.domain.repository

import com.eshc.travelplatform.domain.model.Spot
import com.eshc.travelplatform.domain.model.SpotSuggestion

interface SpotRepository {
    suspend fun getSuggestions() : List<SpotSuggestion>

    suspend fun postKeep(spot : Spot)
}