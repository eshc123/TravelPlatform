package com.eshc.travelplatform.data.local

import com.eshc.travelplatform.data.local.db.dao.KeepDao
import com.eshc.travelplatform.data.local.db.entity.Keep


class KeepLocalDataSource  (private val keepDao : KeepDao
){
    suspend fun insertKeep(spotId: Int){
        keepDao.insertKeep(Keep(spotId =spotId))
    }
}