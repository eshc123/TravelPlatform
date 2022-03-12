package com.eshc.travelplatform.data.repository

import com.eshc.travelplatform.data.local.KeepLocalDataSource
import com.eshc.travelplatform.data.local.SpotLocalDataSource
import com.eshc.travelplatform.data.mapper.Mapper
import com.eshc.travelplatform.domain.model.Spot
import com.eshc.travelplatform.domain.model.Suggestion
import com.eshc.travelplatform.domain.repository.SpotRepository
import kotlinx.coroutines.flow.first

class SpotRepositoryImpl(val spotDataSource: SpotLocalDataSource,val keepDataSource : KeepLocalDataSource) : SpotRepository {

   val allSpots = spotDataSource.allSpots

   override suspend fun getSuggestions(): List<Suggestion>{
      return Mapper().mapperToSuggestion( allSpots.first())
   }

   override suspend fun postKeep(spot: Spot) {
      keepDataSource
   }


}