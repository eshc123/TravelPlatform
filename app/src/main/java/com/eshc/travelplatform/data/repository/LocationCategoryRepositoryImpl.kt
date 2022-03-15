package com.eshc.travelplatform.data.repository

import com.eshc.travelplatform.data.local.KeepLocalDataSource
import com.eshc.travelplatform.data.local.LocationCategoryLocalDataSource
import com.eshc.travelplatform.data.local.SpotLocalDataSource
import com.eshc.travelplatform.data.mapper.Mapper
import com.eshc.travelplatform.domain.model.Spot
import com.eshc.travelplatform.domain.repository.LocationCategoryRepository
import com.eshc.travelplatform.domain.repository.SpotRepository
import kotlinx.coroutines.flow.first

class LocationCategoryRepositoryImpl(val locationCategoryLocalDataSource: LocationCategoryLocalDataSource) : LocationCategoryRepository {

   val allSpots = locationCategoryLocalDataSource.allLocationCategories

}