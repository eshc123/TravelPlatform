package com.eshc.data.repository

import com.eshc.data.local.datasource.KeepLocalDataSource
import com.eshc.data.local.datasource.SpotLocalDataSource
import com.eshc.data.local.datasource.toSpot
import com.eshc.data.local.datasource.toSpotList
import com.eshc.data.remote.datasourceImpl.SpotRemoteDataSourceImpl
import com.eshc.domain.model.Spot
import com.eshc.domain.repository.SpotRepository
import javax.inject.Inject

class SpotRepositoryImpl @Inject constructor(val spotRemoteDataSourceImpl: SpotRemoteDataSourceImpl) : SpotRepository {



   override suspend fun getSuggestions(): List<Spot>{
      return emptyList()
   }

   override suspend fun getPopularSpots(): List<Spot> {
      return emptyList()
   }

   override suspend fun postKeep(spot: Spot) {
   }

   override suspend fun getKeepSpots(): List<Spot> {
      return emptyList()
   }

   override suspend fun getSpot(id: Int): Spot {
      return Spot(0)
   }

   override suspend fun deleteKeep(spot: Spot) {

   }
}