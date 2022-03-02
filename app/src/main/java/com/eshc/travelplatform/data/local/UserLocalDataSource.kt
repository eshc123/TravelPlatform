package com.eshc.travelplatform.data.local

import androidx.annotation.WorkerThread
import com.eshc.travelplatform.data.local.db.dao.UserDao
import com.eshc.travelplatform.data.local.db.entity.User
import com.eshc.travelplatform.data.model.Result
import com.eshc.travelplatform.data.model.LoggedInUser
import kotlinx.coroutines.flow.Flow
import java.io.IOException
import java.util.*

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class UserLocalDataSource(private val userDao : UserDao) {

    val allUsers : Flow<List<User>> = userDao.getUsers()

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication
            val fakeUser = LoggedInUser(UUID.randomUUID().toString(), "Jane Doe")
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(username: String, password: String,phoneNum:String): Result<LoggedInUser> {
        try {
            userDao.insertUser(User(userId = username,password = password,phoneNum = phoneNum))
            val fakeUser = LoggedInUser(UUID.randomUUID().toString(), "Jane Doe")
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }
}