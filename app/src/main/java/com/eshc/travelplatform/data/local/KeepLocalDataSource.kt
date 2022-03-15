package com.eshc.travelplatform.data.local

import com.eshc.travelplatform.data.local.db.dao.KeepDao
import com.eshc.travelplatform.data.local.db.entity.KeepEntity


class KeepLocalDataSource  (private val keepDao : KeepDao
){
    suspend fun insertKeep(spotId: Int){
        keepDao.insertKeep(KeepEntity(spotId =spotId))
    }
}