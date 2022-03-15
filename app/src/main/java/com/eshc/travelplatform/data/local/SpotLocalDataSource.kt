package com.eshc.travelplatform.data.local

import com.eshc.travelplatform.data.local.db.dao.SpotDao
import com.eshc.travelplatform.data.local.db.entity.SpotEntity
import kotlinx.coroutines.flow.Flow


class SpotLocalDataSource (private val spotDao : SpotDao
){
    val allSpots : Flow<List<SpotEntity>> = spotDao.getSpots()


}