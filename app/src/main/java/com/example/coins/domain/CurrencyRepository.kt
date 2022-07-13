package com.example.coins.domain

import com.example.coins.domain.entity.Country

interface CurrencyRepository {
    suspend fun getCurrencyDetails(currency:String): List<Country>


}