package com.eshc.travelplatform.data.local

import com.eshc.travelplatform.data.local.db.dao.KeepDao
import com.eshc.travelplatform.data.local.db.entity.Keep
import com.eshc.travelplatform.domain.model.Spot
import com.eshc.travelplatform.domain.model.Suggestion


class KeepLocalDataSource  (private val keepDao : KeepDao
){
    suspend fun insertKeep(suggestion: Suggestion){
        keepDao.insertKeep(Keep(spotId =suggestion.id ))
    }
}