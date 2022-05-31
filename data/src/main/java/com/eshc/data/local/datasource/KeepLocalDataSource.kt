package com.eshc.data.local.datasource

import com.eshc.data.local.db.dao.KeepDao
import com.eshc.data.local.db.entity.KeepEntity
import com.eshc.domain.model.Spot


class KeepLocalDataSource  (private val keepDao : KeepDao
){
    suspend fun insertKeep(spotId: Int){
        keepDao.insertKeep(KeepEntity(spotId =spotId))
    }

    suspend fun deleteKeep(spot : Spot){
        keepDao.deleteKeep(spot.id)
    }
}