package com.eshc.domain.repository

import com.eshc.domain.model.User

interface UserRepository {
    suspend fun login(username: String, password: String)

    suspend fun register(username: String, password: String)

    fun setLoggedInUser(user: User)

    fun logout()
}