package com.eshc.data.local.datasourceImpl

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.eshc.data.local.datasource.UserLocalDataSource
import com.eshc.domain.model.Token
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.map
import javax.inject.Inject

private const val USER_PREFERENCES = "user_preferences"

val Context.userDataStore : DataStore<Preferences> by preferencesDataStore(name=USER_PREFERENCES)

class UserLocalDataSourceImpl @Inject constructor(@ApplicationContext val appContext: Context) : UserLocalDataSource {
    companion object {
        val ACCESS_TOKEN = stringPreferencesKey("ACCESS_TOKEN")
        val REFRESH_TOKEN = stringPreferencesKey("REFRESH_TOKEN")
    }

    override suspend fun saveToken(token : Token) {
        appContext.userDataStore.edit { tokens ->
            tokens[ACCESS_TOKEN] = token.accessToken
            tokens[REFRESH_TOKEN] = token.refreshToken
        }
    }

    override suspend fun getToken() = appContext.userDataStore.data.map { token ->
        Token(
            accessToken = token[ACCESS_TOKEN] ?: "null",
            refreshToken = token[REFRESH_TOKEN] ?: "null"
        )
    }

}