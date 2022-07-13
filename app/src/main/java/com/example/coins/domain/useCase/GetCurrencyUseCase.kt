package com.example.coins.domain.useCase

import com.example.coins.domain.CurrencyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class GetCurrencyUseCase(private val repository: CurrencyRepository) {
    fun invoke (currency: String) = flow {
        emit(repository.getCurrencyDetails(currency = currency))
    }.flowOn(Dispatchers.IO)

}