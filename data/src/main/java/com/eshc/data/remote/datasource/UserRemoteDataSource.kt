package com.eshc.data.remote.datasource

import com.eshc.domain.model.Result
import com.eshc.domain.model.User
import java.io.IOException
import java.util.*


interface UserRemoteDataSource {

    suspend fun login(username: String, password: String)

    suspend fun logout()

    suspend fun register(username: String, password: String)
}