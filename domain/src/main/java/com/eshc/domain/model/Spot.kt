package com.eshc.domain.model

data class Spot(
    val id: Int,
    val title: String? = null,
    val category: String? = null,
    val address: String? = null,
    var mine: Boolean? = null,
    val distance: String? = null,
    val url: String? = null,
    val point: Pair<Double, Double>? = null
)
