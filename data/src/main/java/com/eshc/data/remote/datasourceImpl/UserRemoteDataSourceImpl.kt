package com.eshc.data.remote.datasourceImpl

import com.eshc.data.remote.datasource.UserRemoteDataSource
import com.eshc.domain.model.Result
import com.eshc.domain.model.User
import java.io.IOException
import java.util.*


class UserRemoteDataSourceImpl () : UserRemoteDataSource{

    override suspend fun login(username: String, password: String){

    }

    override suspend  fun logout() {

    }

    override suspend fun register(username: String, password: String) {

    }
}