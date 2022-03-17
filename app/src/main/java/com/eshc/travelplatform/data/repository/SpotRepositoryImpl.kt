package com.eshc.travelplatform.data.repository

import com.eshc.travelplatform.data.local.KeepLocalDataSource
import com.eshc.travelplatform.data.local.SpotLocalDataSource
import com.eshc.travelplatform.data.local.toMySpot
import com.eshc.travelplatform.data.local.toSpot
import com.eshc.travelplatform.data.mapper.Mapper
import com.eshc.travelplatform.domain.model.Spot
import com.eshc.travelplatform.domain.repository.SpotRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class SpotRepositoryImpl(val spotDataSource: SpotLocalDataSource,val keepDataSource : KeepLocalDataSource) : SpotRepository {

   override suspend fun getSuggestions(): List<Spot>{
      val allSpots = spotDataSource.getSpots().toSpot()
      val keepMap = spotDataSource.getKeepSpotsMap()
      allSpots.map {
         it.mine = keepMap.get(it.id)
      }
      return allSpots
   }

   override suspend fun getPopularSpots(): List<Spot> {
      return spotDataSource.getPopularSpots().toSpot()
   }

   override suspend fun postKeep(spot: Spot) {
      keepDataSource.insertKeep(spot.id)
   }

   override suspend fun getKeepSpots(): List<Spot> {
      return spotDataSource.getKeepSpots().toSpot()
   }

}