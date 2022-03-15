package com.eshc.travelplatform.data.local

import androidx.annotation.WorkerThread
import com.eshc.travelplatform.data.local.db.dao.UserDao
import com.eshc.travelplatform.data.model.Result
import com.eshc.travelplatform.data.local.db.entity.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class UserLocalDataSource(private val userDao : UserDao) {

    val allUsers : Flow<List<UserEntity>> = userDao.getUsers()


    suspend fun login(username: String, password: String): Result<Boolean> {
        if(userDao.getPassword(username).first() == password) {
            try {

                // TODO: handle loggedInUser authentication

                return Result.Success(true)
            } catch (e: Throwable) {
                return Result.Error(IOException("Error logging in", e))
            }
        }
        else
            return Result.Error(IOException(""))
    }

    fun logout() {
        // TODO: revoke authentication
    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(username: String, password: String,phoneNum:String): Result<Boolean> {
        try {
            userDao.insertUser(UserEntity(userId = username,password = password,phoneNum = phoneNum))
            return Result.Success(true)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }
}