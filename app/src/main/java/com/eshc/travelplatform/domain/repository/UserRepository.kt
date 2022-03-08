package com.eshc.travelplatform.domain.repository

import com.eshc.travelplatform.data.model.LoggedInUser
import com.eshc.travelplatform.data.model.Result

interface UserRepository {
    suspend fun login(username: String, password: String) : Result<LoggedInUser>

    suspend fun register(username: String, password: String, phoneNum: String): Result<LoggedInUser>

    fun setLoggedInUser(loggedInUser: LoggedInUser)

    fun logout()
}