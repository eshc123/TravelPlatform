package com.eshc.travelplatform.data.local.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eshc.travelplatform.data.local.db.entity.KeepEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface KeepDao {
    @Query("SELECT * FROM keep_table")
    fun getKeeps() : Flow<List<KeepEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertKeep(keepEntity: KeepEntity)

}