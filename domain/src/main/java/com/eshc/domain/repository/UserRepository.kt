package com.eshc.domain.repository

import com.eshc.domain.model.Token
import com.eshc.domain.model.User

interface UserRepository {
    suspend fun login(username: String, password: String)

    suspend fun register(username: String, password: String)

    suspend fun getToken() : Token

    suspend fun getRemoteToken() : Token

    suspend fun getLocalToken() : Token

    suspend fun refreshToken() : Token

    suspend fun saveToken(token: Token)

    fun setLoggedInUser(user: User)

    fun logout()
}