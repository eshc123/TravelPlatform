package com.eshc.data.local.datastore

import android.app.Application
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.migrations.SharedPreferencesMigration
import androidx.datastore.preferences.SharedPreferencesMigration
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import androidx.datastore.preferences.preferencesDataStoreFile
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton



class UserPreferencesModule @Inject constructor(@ApplicationContext appContext: Context){

    companion object {

    }



//    private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name="user_preferences")
//
//    private val userIdKey = stringPreferencesKey("userId")
//    private val passwordKey = stringPreferencesKey("password")
//    suspend fun setUserId(userId: String){
//        context.dataStore.edit { preferences ->
//            preferences[userIdKey] = userId
//        }
//    }
//
//    suspend fun setPassword(password: String){
//        context.dataStore.edit { preferences ->
//            preferences[passwordKey] = password
//        }
//    }
//
//
//    val userId : Flow<String> = context.dataStore.data
//        .catch { exception ->
//            if (exception is IOException) {
//                emit(emptyPreferences())
//            } else {
//                throw exception
//            }
//        }
//        .map { preferences ->
//            preferences[userIdKey] ?: ""
//        }
//
//    val password : Flow<String> = context.dataStore.data
//        .catch { exception ->
//            if (exception is IOException) {
//                emit(emptyPreferences())
//            } else {
//                throw exception
//            }
//        }
//        .map { preferences ->
//            preferences[passwordKey] ?: ""
//        }


}