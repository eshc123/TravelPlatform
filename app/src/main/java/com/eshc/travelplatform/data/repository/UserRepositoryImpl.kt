package com.eshc.travelplatform.data.repository

import com.eshc.travelplatform.data.local.UserLocalDataSource
import com.eshc.travelplatform.data.model.Result
import com.eshc.travelplatform.domain.model.User
import com.eshc.travelplatform.domain.repository.UserRepository
import java.io.IOException
import java.util.*

class UserRepositoryImpl(val dataSource: UserLocalDataSource) : UserRepository {

    var user: User? = null
        private set

    val allUsers = dataSource.allUsers


    init {
        user = null
    }

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
                    "Jane Doe"
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
                    "Jane Doe"
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