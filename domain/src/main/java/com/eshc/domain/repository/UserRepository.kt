package com.eshc.domain.repository

import com.eshc.domain.model.User

interface UserRepository {
    suspend fun login(username: String, password: String) : com.eshc.domain.model.Result<User>

    suspend fun register(username: String, password: String, phoneNum: String): com.eshc.domain.model.Result<User>

    fun setLoggedInUser(user: User)

    fun logout()
}