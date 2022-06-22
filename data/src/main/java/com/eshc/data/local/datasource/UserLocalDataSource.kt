package com.eshc.data.local.datasource

//import com.eshc.travelplatform.MainApplication
import com.eshc.domain.model.Token
import kotlinx.coroutines.flow.Flow

//token 사용시 datastore 사용을 위해 삭제는 하지 않았음
interface UserLocalDataSource {
    suspend fun saveToken(token : Token)

    suspend fun getToken() : Flow<Token?>
}
