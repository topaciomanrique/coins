package com.example.coins.data.remote.builder

import com.example.coins.data.remote.builder.RetrofitBuilder.Constants.CONTENT_TYPE
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit

class RetrofitBuilder(private val baseUrl:String) {
    private object Constants {
        const val CONTENT_TYPE = "application/json"
    }
    private val bodyInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val contentType = CONTENT_TYPE.toMediaType()
    private val timeout = 100L

    fun build(): Retrofit =
        Retrofit.Builder()
            .client(buildHttpClient())
            .baseUrl(baseUrl)
            .addConverterFactory(
                Json {
                    ignoreUnknownKeys = true
                }.asConverterFactory(contentType)
            )
            .build()

    private fun buildHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(timeout, TimeUnit.SECONDS)
            .readTimeout(timeout, TimeUnit.SECONDS)
            .apply { addInterceptor(bodyInterceptor) }
            .build()
}