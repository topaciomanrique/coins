package com.example.coins.di.presentation

import com.example.coins.presentation.details.CurrencyDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val currencyDetailModule = module {
    viewModel {
        CurrencyDetailViewModel(get())
    }
}