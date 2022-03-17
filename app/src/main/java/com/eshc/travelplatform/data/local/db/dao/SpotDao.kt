package com.eshc.travelplatform.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eshc.travelplatform.data.local.db.entity.SpotEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface SpotDao {
    @Query("SELECT * FROM spot_table")
    suspend fun getSpots() : List<SpotEntity>

    @Query("SELECT * FROM spot_table WHERE id BETWEEN 1 AND 4")
    suspend fun getPopularSpots() : List<SpotEntity>

    @Query("SELECT spot_table.* FROM spot_table JOIN keep_table WHERE spot_id == spot_table.id")
    suspend fun getKeepSpots() : List<SpotEntity>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertSpots(spotEntities : List<SpotEntity>)

}