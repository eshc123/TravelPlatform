package com.eshc.travelplatform.domain.model

data class Suggestion(val title: String? = null,
                      val category : String? = null,
                      val address : String? = null,
                      val mine : Boolean? = null,
                      val distance: String? = null)