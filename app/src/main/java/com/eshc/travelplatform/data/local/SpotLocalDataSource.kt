package com.eshc.travelplatform.data.local

import com.eshc.travelplatform.data.local.db.dao.SpotDao
import com.eshc.travelplatform.data.local.db.entity.SpotEntity
import com.eshc.domain.model.Spot


class SpotLocalDataSource (private val spotDao : SpotDao){

    suspend fun getSpots() : List<SpotEntity> = spotDao.getSpots()

    suspend fun getPopularSpots() : List<SpotEntity> = spotDao.getPopularSpots()

    suspend fun getKeepSpots() : List<SpotEntity> = spotDao.getKeepSpots()

    suspend fun getKeepSpotsMap() : Map<Int,Boolean> = spotDao.getKeepSpots().map { it.id to true }.toMap()

    suspend fun getSpot(id : Int) : SpotEntity = spotDao.getSpot(id)

}
fun List<SpotEntity>.toSpotList() : List<Spot>{
    return this.map {
        Spot(
            id = it.id,
            title = it.name,
            category = it.category,
            address = it.address,
            url = it.image,
            point = Pair(it.x,it.y)
        )
    }
}
fun SpotEntity.toSpot() : Spot{
    return Spot(
        id = this.id,
        title = this.name,
        category = this.category,
        address = this.address,
        url = this.image,
        point = Pair(this.x,this.y)
    )
}

