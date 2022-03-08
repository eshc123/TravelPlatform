package com.eshc.travelplatform.data.repository

import com.eshc.travelplatform.data.local.UserLocalDataSource
import com.eshc.travelplatform.data.remote.UserRemoteDataSource
import com.eshc.travelplatform.data.model.Result
import com.eshc.travelplatform.data.model.LoggedInUser
import com.eshc.travelplatform.domain.repository.UserRepository

class UserRepositoryImpl(val dataSource: UserLocalDataSource) : UserRepository {

    var user: LoggedInUser? = null
        private set

    val allUsers = dataSource.allUsers


    init {
        user = null
    }

    override fun logout() {
        user = null
        dataSource.logout()
    }



    override suspend fun login(username: String, password: String): Result<LoggedInUser> {
        val result = dataSource.login(username, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    override suspend fun register(
        username: String,
        password: String,
        phoneNum: String
    ): Result<LoggedInUser> {
        val result = dataSource.insert(username, password, phoneNum)
        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }
        return result
    }

    override fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser

    }
}