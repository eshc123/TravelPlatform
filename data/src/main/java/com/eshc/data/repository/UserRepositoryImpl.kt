package com.eshc.data.repository

import com.eshc.data.local.UserLocalDataSource
import com.eshc.domain.model.Result
import com.eshc.domain.model.User
import com.eshc.domain.repository.UserRepository
import java.io.IOException
import java.util.*

class UserRepositoryImpl(val dataSource: UserLocalDataSource) : UserRepository {

    var user: User? = null
        private set
    override fun logout() {
        user = null
        dataSource.logout()
    }

    override suspend fun login(username: String, password: String): Result<User> {
        val result = dataSource.login(username, password)

        if (result is Result.Success) {
            val fakeUser =
                User(
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString()
                )
            setLoggedInUser(fakeUser)
            return Result.Success(fakeUser)
        }
        else {
            return Result.Error(IOException("Error logging in"))
        }
    }

    override suspend fun register(
        username: String,
        password: String,
        phoneNum: String
    ): Result<User> {
        val result = dataSource.insert(username, password, phoneNum)
        if (result is Result.Success) {
            val fakeUser =
                User(
                    UUID.randomUUID().toString(),
                    UUID.randomUUID().toString()
                )
            setLoggedInUser(fakeUser)
            return Result.Success(fakeUser)
        }
        else {
            return Result.Error(IOException("Error logging in"))
        }
    }

    override fun setLoggedInUser(user: User) {
        this.user = user

    }
}