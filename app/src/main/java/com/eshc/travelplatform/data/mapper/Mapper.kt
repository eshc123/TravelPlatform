package com.eshc.travelplatform.data.mapper

import com.eshc.travelplatform.data.local.db.entity.SpotEntity
import com.eshc.travelplatform.domain.model.Spot

class Mapper {
    fun mapperToSpots(spotEntities : List<SpotEntity>) : List<Spot>{
        return spotEntities.toList().map {
            Spot(
                id = it.id,
                title = it.name,
                category = it.category,
                address = it.address,
                distance = "42.195Km",
                point = Pair(it.x,it.y)
            )
        }
    }
}