package com.eshc.travelplatform.data.mapper

import com.eshc.travelplatform.data.local.db.entity.Spot
import com.eshc.travelplatform.domain.model.Suggestion

class Mapper {
    fun mapperToSuggestion(spots : List<Spot>) : List<Suggestion>{
        return spots.toList().map {
            Suggestion(
                title = it.name,
                category = it.category,
                address = it.address,
                distance = "42.195Km",
                point = Pair(it.x,it.y)
            )
        }
    }
}