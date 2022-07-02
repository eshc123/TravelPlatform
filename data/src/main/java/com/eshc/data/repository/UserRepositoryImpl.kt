package com.eshc.data.repository

import com.eshc.data.local.datasourceImpl.UserLocalDataSourceImpl
import com.eshc.domain.model.Token
import com.eshc.data.remote.datasourceImpl.UserRemoteDataSourceImpl
import com.eshc.domain.model.User
import com.eshc.domain.repository.UserRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.single
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(val userRemoteDataSourceImpl: UserRemoteDataSourceImpl,
                                             val userLocalDataSourceImpl: UserLocalDataSourceImpl
) : UserRepository {

    var user: User? = null
        private set

    private var cachedToken : Token? = null

    override fun logout() {
        user = null

    }

    override suspend fun login(username: String, password: String) {
        userRemoteDataSourceImpl.login(username,password)
//        val result = dataSource.login(username, password)
//
//        if (result is Result.Success) {
//            val fakeUser =
//                User(
//                    UUID.randomUUID().toString(),
//                    UUID.randomUUID().toString()
//                )
//            setLoggedInUser(fakeUser)
//            //return Result.Success(fakeUser)
//        }
//        else {
//           // return Result.Error(IOException("Error logging in"))
//        }
    }

    override suspend fun register(
        username: String,
        password: String
    ){
//        val result = dataSource.insert(username, password, "123")
//        if (result is Result.Success) {
//            val fakeUser =
//                User(
//                    UUID.randomUUID().toString(),
//                    UUID.randomUUID().toString()
//                )
//            setLoggedInUser(fakeUser)
//           // return Result.Success(fakeUser)
//        }
//        else {
//           // return Result.Error(IOException("Error logging in"))
//        }
    }

    override suspend fun getToken(): Token {
        val cachedToken = this.cachedToken
        if(cachedToken != null){
            return getRemoteToken().also {  }
        }
        val localToken = userLocalDataSourceImpl.getToken().firstOrNull()
        if(localToken != null)
            return localToken.also { this.cachedToken = it }
        return refreshToken()
    }

    override suspend fun getRemoteToken(): Token {
        TODO("Not yet implemented")
    }

    override suspend fun getLocalToken(): Token {
        TODO("Not yet implemented")
    }

    override suspend fun refreshToken(): Token {
        TODO("Not yet implemented")
    }

    override suspend fun saveToken(token: Token) {
        TODO("Not yet implemented")
    }

    override fun setLoggedInUser(user: User) {
        this.user = user

    }
}