package com.example.coins.di

import com.example.coins.data.CurrencyRepositoryImpl
import com.example.coins.data.remote.service.CurrencyService
import com.example.coins.domain.CurrencyRepository
import com.example.coins.domain.useCase.GetCurrencyUseCase
import org.koin.dsl.module
import retrofit2.Retrofit

val currencyModule = module {
    factory { GetCurrencyUseCase(get()) }
    single<CurrencyRepository> {CurrencyRepositoryImpl(get())  }
    single {
        get<Retrofit>().create(CurrencyService::class.java)
    }
}