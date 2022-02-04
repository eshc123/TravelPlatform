package com.eshc.travelplatform.shared.util

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException


class DataStoreUtil(private val context : Context) {

    private val Context.dataStore : DataStore<Preferences> by preferencesDataStore(name=context.packageName)

    private val userIdKey = stringPreferencesKey("userId")
    private val passwordKey = stringPreferencesKey("password")
    private val hasPlansKey = booleanPreferencesKey("hasPlans")
    suspend fun setUserId(userId: String){
        context.dataStore.edit { preferences ->
            preferences[userIdKey] = userId
        }
    }

    suspend fun setPassword(password: String){
        context.dataStore.edit { preferences ->
            preferences[passwordKey] = password
        }
    }

    suspend fun setHasPlans(bool : Boolean){
        context.dataStore.edit { preferences ->
            preferences[hasPlansKey] = bool
        }
    }

    val userId : Flow<String> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            preferences[userIdKey] ?: ""
        }

    val password : Flow<String> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            preferences[passwordKey] ?: ""
        }
    val hasPlans : Flow<Boolean> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) {
                emit(emptyPreferences())
            } else {
                throw exception
            }
        }
        .map { preferences ->
            preferences[hasPlansKey] ?: false
        }
    suspend fun clearAccount(){

    }
}