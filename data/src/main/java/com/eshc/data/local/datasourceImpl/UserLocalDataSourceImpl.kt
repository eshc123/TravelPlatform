package com.eshc.data.local.datasourceImpl

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.eshc.data.local.datasource.UserLocalDataSource
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

private const val USER_PREFERENCES = "user_preferences"

val Context.userDataStore : DataStore<Preferences> by preferencesDataStore(name=USER_PREFERENCES)

class UserLocalDataSourceImpl @Inject constructor(@ApplicationContext appContext: Context) : UserLocalDataSource {
    companion object {
        val ACCESS_TOKEN = stringPreferencesKey("ACCESS_TOKEN")
        val REFRESH_TOKEN = stringPreferencesKey("REFRESH_TOKEN")
    }
}