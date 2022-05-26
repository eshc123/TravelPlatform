package com.eshc.data.repository

import com.eshc.data.local.LocationCategoryLocalDataSource
import com.eshc.domain.repository.LocationCategoryRepository

class LocationCategoryRepositoryImpl(val locationCategoryLocalDataSource: LocationCategoryLocalDataSource) : LocationCategoryRepository {

   val allSpots = locationCategoryLocalDataSource.allLocationCategories

}