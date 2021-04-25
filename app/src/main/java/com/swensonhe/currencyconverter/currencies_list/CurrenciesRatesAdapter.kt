package com.swensonhe.currencyconverter.currencies_list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.swensonhe.currencyconverter.R
import com.swensonhe.currencyconverter.models.RatesModel
import com.swensonhe.currencyconverter.models.RatesModel.Companion.DIFF_UTIL
import kotlinx.android.synthetic.main.item_currency.view.*

/**
 * Created by George on 4/24/21.
 */
class CurrenciesRatesAdapter(
    private val callback: (RatesModel) -> Unit
) : ListAdapter<RatesModel, CurrenciesRatesAdapter.CurrenciesRateViewHolder>(DIFF_UTIL) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CurrenciesRateViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_currency, parent, false)

        return CurrenciesRateViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CurrenciesRateViewHolder, position: Int) {
        holder.bind(currentList[position])
    }

    inner class CurrenciesRateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(ratesModel: RatesModel) = with(itemView) {
            tv_currency.text = ratesModel.currency
            tv_rate.text = ratesModel.rate.toString()

            itemView.setOnClickListener { callback(ratesModel) }
        }
    }
}