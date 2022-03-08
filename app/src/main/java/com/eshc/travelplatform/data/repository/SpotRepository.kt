package com.eshc.travelplatform.data.repository

import com.eshc.travelplatform.data.local.SpotLocalDataSource
import com.eshc.travelplatform.data.local.UserLocalDataSource
import com.eshc.travelplatform.data.remote.UserRemoteDataSource
import com.eshc.travelplatform.data.model.Result
import com.eshc.travelplatform.data.model.LoggedInUser
import com.eshc.travelplatform.domain.model.Suggestion

class SpotRepository(val dataSource: SpotLocalDataSource) {

   val allSpots = dataSource.allSpots


}