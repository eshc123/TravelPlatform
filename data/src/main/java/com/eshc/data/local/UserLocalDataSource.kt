package com.eshc.data.local

import androidx.annotation.WorkerThread
//import com.eshc.travelplatform.MainApplication
import com.eshc.domain.model.Result
import com.eshc.data.local.db.dao.UserDao
import com.eshc.data.local.db.entity.UserEntity
import com.eshc.domain.model.User
import java.io.IOException

class UserLocalDataSource(private val userDao : UserDao) {
    suspend fun login(username: String, password: String): Result<Boolean> {
        if(userDao.getPassword(username) == password) {
            try {
                //MainApplication.getInstance().user = getUser(username)

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
            val user = UserEntity(userId = username,password = password,phoneNum = phoneNum)
            userDao.insertUser(user)
            //MainApplication.getInstance().user = user.toUser()
            return Result.Success(true)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }
    suspend fun getUser(username : String) : User {
       return  ( userDao.getUserById(username).toUser())
    }
}
fun UserEntity.toUser() : User{
    return User(
        this.userId,
        this.userId,
        this.phoneNum
    )
}