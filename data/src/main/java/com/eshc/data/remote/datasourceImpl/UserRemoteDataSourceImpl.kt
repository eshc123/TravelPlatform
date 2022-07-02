package com.eshc.data.remote.datasourceImpl

import android.util.Log
import com.eshc.data.remote.api.TravelService
import com.eshc.data.remote.datasource.UserRemoteDataSource
import com.eshc.domain.model.Result
import com.eshc.domain.model.User
import java.io.IOException
import java.util.*
import javax.inject.Inject


class UserRemoteDataSourceImpl @Inject constructor (private val travelService : TravelService) : UserRemoteDataSource{

    override suspend fun login(username: String, password: String){
        val l = travelService.login(username,password)
        Log.d("asdasd",l.isSuccessful.toString())
    }

    override suspend  fun logout() {

    }

    override suspend fun register(username: String, password: String) {

    }
}