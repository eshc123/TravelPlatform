package com.eshc.travelplatform

import android.app.Application
import com.eshc.data.local.datasource.*
import com.eshc.data.local.db.AppDatabase
import com.eshc.domain.model.User
import dagger.hilt.android.HiltAndroidApp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.first

@HiltAndroidApp
class MainApplication : Application() {
    private val applicationScope = CoroutineScope(SupervisorJob())
    var user : User? = null

    val database by lazy { AppDatabase.getDatabase(this,applicationScope) }
    val spotLocalDataSource by lazy { SpotLocalDataSource(database.spotDao()) }
    val keepLocalDataSource by lazy { KeepLocalDataSource(database.keepDao()) }
    val scheduleDataSource by lazy { ScheduleLocalDataSource(database.scheduleDao()) }
    val dailyScheduleDataSource by lazy { DailyScheduleLocalDataSource() }

    companion object {
        private lateinit var mainApplication: MainApplication
        fun getInstance() : MainApplication = mainApplication
    }


    override fun onCreate() {
        super.onCreate()
        mainApplication = this
    }


//    suspend fun isLogin() : Boolean {
//        val id = getInstance().getDataStore().userId.first()
//        val pw = getInstance().getDataStore().password.first()
//        return !(id.isBlank() || pw.isBlank())
//    }


}