package com.example.coins.data.remote.extension

import org.json.JSONObject
import retrofit2.HttpException
import retrofit2.Response

suspend fun <T>retrofitCall(apiCall: suspend () -> Response<T>): Response<T> {
    val response = apiCall()
    return if (response.isSuccessful)
        response
    else throw HttpException(response)
}
fun HttpException.errorMessage(): String {
    return try {
        val errorBody = JSONObject(response()?.errorBody()?.string()!!)
        errorBody.getString("message") ?: message()
    } catch (e: Exception) {
        message()
    }
}