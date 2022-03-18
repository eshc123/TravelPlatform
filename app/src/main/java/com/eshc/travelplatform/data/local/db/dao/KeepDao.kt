package com.eshc.travelplatform.data.local.db.dao

import androidx.room.*
import com.eshc.travelplatform.data.local.db.entity.KeepEntity
import com.eshc.travelplatform.domain.model.Spot
import kotlinx.coroutines.flow.Flow

@Dao
interface KeepDao {
    @Query("SELECT * FROM keep_table")
    fun getKeeps() : Flow<List<KeepEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertKeep(keepEntity: KeepEntity)

    @Query("DELETE FROM keep_table WHERE :spot_id == spot_id")
    suspend fun deleteKeep(spot_id: Int)
}