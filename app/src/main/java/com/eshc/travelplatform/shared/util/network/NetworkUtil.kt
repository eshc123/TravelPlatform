package com.eshc.travelplatform.shared.util.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

val API_BASE_URL = ""
val timeout = 10L

lateinit var client: OkHttpClient
lateinit var retrofit: Retrofit
lateinit var networkInterface: NetworkInterface

fun networkInit() {
    val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    client = OkHttpClient.Builder()
        .addInterceptor(logging)
        .readTimeout(timeout, TimeUnit.SECONDS)
        .connectTimeout(timeout, TimeUnit.SECONDS)
        .writeTimeout(timeout, TimeUnit.SECONDS)
        .build()

    networkInterface = retrofit.create(NetworkInterface::class.java)
}

fun getNetworkInstance() = networkInterface

