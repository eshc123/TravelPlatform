package com.eshc.data.remote.api

import com.eshc.domain.model.Token
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.POST

interface TravelService {
    @POST("login")
    suspend fun login(@Field("userEmail") userEmail : String,
                      @Field("userPassword") userPassword : String
    ) : Response<TravelResponse<Token>>

}