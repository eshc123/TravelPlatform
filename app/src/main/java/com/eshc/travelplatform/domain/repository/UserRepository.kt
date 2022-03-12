package com.eshc.travelplatform.domain.repository

import com.eshc.travelplatform.domain.model.User
import com.eshc.travelplatform.data.model.Result

interface UserRepository {
    suspend fun login(username: String, password: String) : Result<User>

    suspend fun register(username: String, password: String, phoneNum: String): Result<User>

    fun setLoggedInUser(user: User)

    fun logout()
}