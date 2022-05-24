package com.eshc.domain.repository

import com.eshc.domain.model.Spot

interface SpotRepository {
    suspend fun getSuggestions() : List<Spot>

    suspend fun getPopularSpots() : List<Spot>

    suspend fun postKeep(spot : Spot)

    suspend fun getKeepSpots() : List<Spot>

    suspend fun getSpot(id : Int) : Spot

    suspend fun deleteKeep(spot: Spot)
}