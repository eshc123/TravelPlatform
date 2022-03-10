package com.eshc.travelplatform.data.repository

import com.eshc.travelplatform.data.local.SpotLocalDataSource
import com.eshc.travelplatform.data.local.UserLocalDataSource
import com.eshc.travelplatform.data.mapper.Mapper
import com.eshc.travelplatform.data.remote.UserRemoteDataSource
import com.eshc.travelplatform.data.model.Result
import com.eshc.travelplatform.data.model.LoggedInUser
import com.eshc.travelplatform.domain.model.Suggestion
import com.eshc.travelplatform.domain.repository.SpotRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.toList

class SpotRepositoryImpl(val dataSource: SpotLocalDataSource) : SpotRepository {

   val allSpots = dataSource.allSpots
   override suspend fun getSuggestions(): List<Suggestion>{
      return Mapper().mapperToSuggestion( allSpots.first())
   }


}