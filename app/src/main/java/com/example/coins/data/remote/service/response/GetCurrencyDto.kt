package com.example.coins.data.remote.service.response

import com.example.coins.data.remote.model.CurrencyDto
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GetCurrencyDto(@SerialName("data") val data:List<CurrencyDto>?)
