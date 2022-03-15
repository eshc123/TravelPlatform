package com.eshc.travelplatform.data.local.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.eshc.travelplatform.data.local.db.entity.CourseEntity
import com.eshc.travelplatform.data.local.db.entity.LocationCategoryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationCategoryDao {
    @Query("SELECT * FROM location_category_table")
    fun getAllLocationCategories() : Flow<List<LocationCategoryEntity>>
}