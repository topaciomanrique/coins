package com.example.coins.data

import com.example.coins.data.remote.extension.errorMessage
import com.example.coins.data.remote.extension.retrofitCall
import com.example.coins.data.remote.service.CurrencyService
import com.example.coins.domain.CurrencyRepository
import com.example.coins.domain.entity.Currency
import com.example.coins.domain.exception.JsonDeserializationException
import java.net.UnknownHostException
import com.example.coins.domain.exception.NetworkConnectionException
import com.example.coins.domain.exception.ServerException
import com.squareup.moshi.JsonDataException
import retrofit2.HttpException

class CurrencyRepositoryImpl(private val service: CurrencyService):CurrencyRepository {
    override suspend fun getCurrencyDetails(currency: String): List<Currency>? = try {
        retrofitCall {
            service.getCurrency(currency)
        }  .body()?.data?.map { it.toEntity() }
    } catch (exception:Exception){
        val failure = when(exception){
            is UnknownHostException -> NetworkConnectionException(exception.message)
            is JsonDataException -> JsonDeserializationException(exception.message)
            is HttpException -> ServerException(exception.errorMessage())
            else -> exception
        }
        throw failure
    }
}