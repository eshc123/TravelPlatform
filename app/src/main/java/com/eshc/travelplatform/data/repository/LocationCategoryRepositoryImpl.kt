package com.eshc.travelplatform.data.repository

import com.eshc.travelplatform.data.local.LocationCategoryLocalDataSource
import com.eshc.domain.repository.LocationCategoryRepository

class LocationCategoryRepositoryImpl(val locationCategoryLocalDataSource: LocationCategoryLocalDataSource) : LocationCategoryRepository {

   val allSpots = locationCategoryLocalDataSource.allLocationCategories

}