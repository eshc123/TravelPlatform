package com.eshc.data.remote.datasourceImpl

import com.eshc.data.remote.datasource.SpotRemoteDataSource
import com.eshc.domain.model.Spot
import javax.inject.Inject


class SpotRemoteDataSourceImpl @Inject constructor() : SpotRemoteDataSource{
    override suspend fun getSpots(): List<Spot> {
        return emptyList()
    }

    override suspend fun getPopularSpots(): List<Spot> {
        return emptyList()
    }

    override suspend fun getKeepSpots(): List<Spot> {
        return emptyList()
    }

    override suspend fun getSpot(spotId: Int): Spot {
        return Spot(0)
    }


}