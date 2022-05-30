package com.eshc.travelplatform

import android.app.Application
import com.eshc.data.local.*
import com.eshc.data.local.db.AppDatabase
import com.eshc.domain.model.User
import com.eshc.travelplatform.shared.util.DataStoreUtil
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.first

@HiltAndroidApp
class MainApplication : Application() {
    private lateinit var dataStore : DataStoreUtil
    private val applicationScope = CoroutineScope(SupervisorJob())
    var user : User? = null

    val database by lazy { AppDatabase.getDatabase(this,applicationScope) }
    val userLocalDataSource by lazy { UserLocalDataSource(database.userDao())}
    val spotLocalDataSource by lazy { SpotLocalDataSource(database.spotDao())}
    val keepLocalDataSource by lazy { KeepLocalDataSource(database.keepDao())}
    val scheduleDataSource by lazy { ScheduleLocalDataSource(database.scheduleDao())}
    val dailyScheduleDataSource by lazy { DailyScheduleLocalDataSource()}
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