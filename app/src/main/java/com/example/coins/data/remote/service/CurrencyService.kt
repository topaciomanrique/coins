package com.example.coins.data.remote.service

import com.example.coins.data.remote.service.response.GetCurrencyDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CurrencyService {
    @GET("getCurrency")
    suspend fun getCurrency(@Query("currency") currency:String, @Query("dummy") dummy:Boolean):Response<GetCurrencyDto>
}