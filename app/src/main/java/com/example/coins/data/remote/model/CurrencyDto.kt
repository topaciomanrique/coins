package com.example.coins.data.remote.model

import com.example.coins.domain.entity.Currency
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurrencyDto(
    @SerialName("name") val name: String?,
    @SerialName("region") val region: String?,
    @SerialName("altSpellings") val altSpellings: List<String>?){
    fun toEntity():Currency = Currency(name?:"", region?:"", altSpellings?:emptyList())
}
