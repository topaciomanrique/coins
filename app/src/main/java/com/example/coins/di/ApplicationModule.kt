package com.example.coins.di

import com.example.coins.CoinsApplication
import com.example.coins.di.presentation.currencyDetailModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

fun CoinsApplication.initKoin(){
    val modules = listOf(currencyModule, httpClientModule, currencyDetailModule)
    startKoin {
        androidContext(applicationContext)
        modules(modules)
    }

}