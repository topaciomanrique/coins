package com.example.coins.presentation.details.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.coins.databinding.ItemCountryBinding
import com.example.coins.domain.entity.Currency

class CurrencyDetailViewHolder(private val binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root){
    companion object{
        fun from(parent: ViewGroup): CurrencyDetailViewHolder = CurrencyDetailViewHolder(
            ItemCountryBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    fun bind(data: Currency) = binding.apply {
        tvCountry.text = data.name
        tvRegion.text = data.region
        tvAltSpellings.text = data.altSpellings.size.toString()
    }
}