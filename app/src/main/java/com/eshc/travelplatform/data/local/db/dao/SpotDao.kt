package com.eshc.travelplatform.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eshc.travelplatform.data.local.db.entity.Course
import com.eshc.travelplatform.data.local.db.entity.Keep
import com.eshc.travelplatform.data.local.db.entity.Spot
import kotlinx.coroutines.flow.Flow

@Dao
interface SpotDao {
    @Query("SELECT * FROM spot_table")
    fun getSpots() : Flow<List<Spot>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSpots(spots : List<Spot>)

}