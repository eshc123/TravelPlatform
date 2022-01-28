package com.eshc.travelplatform

import android.app.Application
import com.eshc.travelplatform.shared.util.DataStoreUtil

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
}