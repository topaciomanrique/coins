package com.example.coins.presentation.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coins.R
import com.example.coins.databinding.ActivityCurrencyDetailBinding
import com.example.coins.databinding.ActivityMainBinding
import com.example.coins.domain.entity.Currency
import com.example.coins.presentation.details.adapter.CurrencyDetailAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CurrencyDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCurrencyDetailBinding
    private val viewModel:CurrencyDetailViewModel by viewModel()
    private lateinit var adapter: CurrencyDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCurrencyDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpUi()
        setUpObserver()
        viewModel.fetchCurrency("USD")

    }

    fun setUpUi(){
        adapter = CurrencyDetailAdapter()
        binding.rvCountries.adapter = adapter
    }

    fun setUpObserver(){
        viewModel.currencies.observe(this){
            it?.let { currencies ->
                adapter.submitList(currencies)
            }
        }
    }
}