package com.eshc.travelplatform

import android.app.Application
import com.eshc.travelplatform.shared.util.DataStoreUtil
import kotlinx.coroutines.flow.first

class MainApplication : Application() {
    private lateinit var dataStore : DataStoreUtil

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

    suspend fun setHasPlans(bool:Boolean) {
        getInstance().getDataStore().setHasPlans(bool)
    }
    suspend fun getHasPlans() : Boolean {
        return getInstance().getDataStore().hasPlans.first()
    }
}