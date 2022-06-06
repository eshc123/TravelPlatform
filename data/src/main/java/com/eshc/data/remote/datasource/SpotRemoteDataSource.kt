package com.eshc.data.remote.datasource

import com.eshc.domain.model.Spot

interface SpotRemoteDataSource {
    suspend fun getSpots() : List<Spot>

    suspend fun getPopularSpots() : List<Spot>

    suspend fun getKeepSpots() : List<Spot>

    suspend fun getSpot(spotId: Int) : Spot
}