package com.example.coins.di

import com.example.coins.data.remote.builder.RetrofitBuilder
import org.koin.dsl.module

val httpClientModule = module{
    single{
        RetrofitBuilder("https://apisprueba.herokuapp.com/country/").build()
    }
}