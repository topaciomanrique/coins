package com.example.coins.presentation.details.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.coins.domain.entity.Currency

class CurrencyDetailAdapter: ListAdapter<Currency, CurrencyDetailViewHolder>(AdapterDiffUtil) {
    internal object AdapterDiffUtil : DiffUtil.ItemCallback<Currency>() {

        override fun areItemsTheSame(
            oldItem: Currency,
            newItem: Currency
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: Currency,
            newItem: Currency
        ): Boolean = oldItem == newItem

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrencyDetailViewHolder {
        return CurrencyDetailViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: CurrencyDetailViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}