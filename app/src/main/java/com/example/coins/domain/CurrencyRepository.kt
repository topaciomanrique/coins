package com.example.coins.domain

import com.example.coins.domain.entity.Currency

interface CurrencyRepository {
    suspend fun getCurrencyDetails(currency:String): List<Currency>?


}