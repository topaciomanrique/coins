package com.example.coins.data.remote.service.response

import com.example.coins.data.remote.model.CurrencyDto
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetCurrencyDto(@Json (name = "data") val data:List<CurrencyDto>?)
