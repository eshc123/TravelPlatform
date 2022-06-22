package com.eshc.travelplatform.util

import okhttp3.Interceptor
import okhttp3.Response

class HttpRequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        //TODO 헤더에 토큰 추가 작업
        val originalRequest = chain.request()
        return chain.proceed(originalRequest)
    }

}