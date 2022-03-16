package com.eshc.travelplatform.data.local

import com.eshc.travelplatform.data.local.db.dao.SpotDao
import com.eshc.travelplatform.data.local.db.entity.SpotEntity
import com.eshc.travelplatform.domain.model.Spot
import kotlinx.coroutines.flow.Flow


class SpotLocalDataSource (private val spotDao : SpotDao){

    suspend fun getSpots() : List<SpotEntity> = spotDao.getSpots()

    suspend fun getPopularSpots() : List<SpotEntity> = spotDao.getPopularSpots()

    suspend fun getKeepSpots() : List<SpotEntity> = spotDao.getKeepSpots()

    suspend fun getKeepSpotById(id:Int) : List<SpotEntity> = spotDao.getKeepSpotById(id)
}
fun List<SpotEntity>.toSpot() : List<Spot>{
    return this.map {
        Spot(
            id = it.id,
            title = it.name,
            category = it.category,
            address = it.address,
            distance = "42.195Km",
            url = it.image,
            point = Pair(it.x,it.y)
        )
    }
}
