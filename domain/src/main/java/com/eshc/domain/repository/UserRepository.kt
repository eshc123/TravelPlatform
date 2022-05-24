package com.eshc.domain.repository

import com.eshc.domain.model.User

interface UserRepository {
    suspend fun login(username: String, password: String) : Result<User>

    suspend fun register(username: String, password: String, phoneNum: String): Result<User>

    fun setLoggedInUser(user: User)

    fun logout()
}