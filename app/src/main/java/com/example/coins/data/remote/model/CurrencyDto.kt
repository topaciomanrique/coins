package com.example.coins.data.remote.model

import com.example.coins.domain.entity.Currency
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CurrencyDto(
    @Json(name = "name") val name: String?,
    @Json(name = "region") val region: String?,
    @Json(name = "altSpellings") val altSpellings: List<String>?){
    fun toEntity():Currency = Currency(name?:"", region?:"", altSpellings?:emptyList())
}
