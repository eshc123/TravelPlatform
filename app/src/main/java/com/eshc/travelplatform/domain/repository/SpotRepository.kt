package com.eshc.travelplatform.domain.repository

import com.eshc.travelplatform.domain.model.Suggestion
import kotlinx.coroutines.flow.Flow

interface SpotRepository {
    suspend fun getSuggestions() : List<Suggestion>
}