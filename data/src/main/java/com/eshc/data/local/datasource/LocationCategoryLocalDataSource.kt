package com.eshc.data.local.datasource

import com.eshc.data.local.db.dao.LocationCategoryDao
import com.eshc.data.local.db.entity.LocationCategoryEntity
import kotlinx.coroutines.flow.Flow


class LocationCategoryLocalDataSource  (private val locationCategoryDao: LocationCategoryDao
){
    val allLocationCategories : Flow<List<LocationCategoryEntity>> = locationCategoryDao.getAllLocationCategories()
}