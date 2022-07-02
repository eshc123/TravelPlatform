package com.eshc.data.remote.api

data class TravelResponse<T>(val code : Int,val data : T, val result : Boolean, val description : String)
