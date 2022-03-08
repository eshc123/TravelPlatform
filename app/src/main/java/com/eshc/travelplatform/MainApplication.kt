package com.eshc.travelplatform

import android.app.Application
import com.eshc.travelplatform.data.local.UserLocalDataSource
import com.eshc.travelplatform.data.local.db.AppDatabase
import com.eshc.travelplatform.shared.util.DataStoreUtil
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.first

class MainApplication : Application() {
    private lateinit var dataStore : DataStoreUtil
    private val applicationScope = CoroutineScope(SupervisorJob())

    val database by lazy { AppDatabase.getDatabase(this,applicationScope) }
    val userLocalDataSource by lazy { UserLocalDataSource(database.userDao())}

    companion object {
        private lateinit var mainApplication: MainApplication
        fun getInstance() : MainApplication = mainApplication
    }


    override fun onCreate() {
        super.onCreate()
        mainApplication = this
        dataStore = DataStoreUtil(this)
    }

    fun getDataStore() : DataStoreUtil = dataStore

    suspend fun isLogin() : Boolean {
        val id = getInstance().getDataStore().userId.first()
        val pw = getInstance().getDataStore().password.first()
        return !(id.isBlank() || pw.isBlank())
    }



}