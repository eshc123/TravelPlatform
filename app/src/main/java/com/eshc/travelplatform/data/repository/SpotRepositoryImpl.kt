package com.eshc.travelplatform.data.repository

import com.eshc.travelplatform.data.local.KeepLocalDataSource
import com.eshc.travelplatform.data.local.SpotLocalDataSource
import com.eshc.travelplatform.data.local.toSpot
import com.eshc.travelplatform.data.local.toSpotList
import com.eshc.domain.model.Spot
import com.eshc.domain.repository.SpotRepository

class SpotRepositoryImpl(val spotDataSource: SpotLocalDataSource,val keepDataSource : KeepLocalDataSource) : SpotRepository {



   override suspend fun getSuggestions(): List<Spot>{
      val allSpots = spotDataSource.getSpots().toSpotList()
      val keepMap = spotDataSource.getKeepSpotsMap()
      allSpots.map {
         it.mine = keepMap.get(it.id)
      }
      return allSpots
   }

   override suspend fun getPopularSpots(): List<Spot> {
      return spotDataSource.getPopularSpots().toSpotList()
   }

   override suspend fun postKeep(spot: Spot) {
      keepDataSource.insertKeep(spot.id)
   }

   override suspend fun getKeepSpots(): List<Spot> {
      return spotDataSource.getKeepSpots().toSpotList()
   }

   override suspend fun getSpot(id: Int): Spot {
      val spot = spotDataSource.getSpot(id).toSpot()
      val keepMap = spotDataSource.getKeepSpotsMap()
      spot.mine = keepMap.get(spot.id)
      return spot
   }

   override suspend fun deleteKeep(spot: Spot) {
      keepDataSource.deleteKeep(spot)
   }
}