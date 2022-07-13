package com.example.coins.data.remote.builder

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitBuilder(private val baseUrl:String) {
    private val moshiConverterFactory = MoshiConverterFactory.create()
    private val timeout = 100L

    fun build(): Retrofit = Retrofit.Builder()
        .client(buildHttpClient())
        .baseUrl(baseUrl).addConverterFactory(moshiConverterFactory).build()

    private fun buildHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(timeout,TimeUnit.SECONDS)
        .readTimeout(timeout, TimeUnit.SECONDS).build()
}