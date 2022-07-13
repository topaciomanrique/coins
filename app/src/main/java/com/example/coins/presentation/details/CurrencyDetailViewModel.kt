package com.example.coins.presentation.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coins.domain.entity.Currency
import com.example.coins.domain.useCase.GetCurrencyUseCase
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import logcat.logcat

class CurrencyDetailViewModel(private val getCurrencyUseCase: GetCurrencyUseCase): ViewModel() {
    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading
    private val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable> = _error
    private val _currencies = MutableLiveData<List<Currency>?>()
    val currencies: LiveData<List<Currency>?> = _currencies

    fun fetchCurrency(value:String)=viewModelScope.launch {
        getCurrencyUseCase.invoke(value)
            .onStart {
                _isLoading.value = true
            }.onCompletion {
                _isLoading.value = false
            }.catch {
                _error.value = it
                logcat { "error: $it" }
            }.collect {
                _currencies.value = it
                logcat { "succes: $it" }
            }

    }
}