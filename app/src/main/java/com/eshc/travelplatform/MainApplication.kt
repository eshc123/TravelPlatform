package com.eshc.travelplatform

import android.app.Application
import com.naver.maps.map.NaverMapSdk

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        NaverMapSdk.getInstance(this).client =
            NaverMapSdk.NaverCloudPlatformClient(BuildConfig.NAVER_MAP_KEY)

    }

}