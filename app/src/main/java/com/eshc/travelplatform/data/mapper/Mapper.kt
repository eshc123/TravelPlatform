package com.eshc.travelplatform.data.mapper

import com.eshc.travelplatform.data.local.db.entity.Spot
import com.eshc.travelplatform.domain.model.SpotSuggestion

class Mapper {
    fun mapperToSuggestion(spots : List<Spot>) : List<SpotSuggestion>{
        return spots.toList().map {
            SpotSuggestion(
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