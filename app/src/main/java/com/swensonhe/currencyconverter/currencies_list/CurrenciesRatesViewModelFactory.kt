package com.swensonhe.currencyconverter.currencies_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by George on 4/24/21.
 */
class CurrenciesRatesViewModelFactory(private val currenciesRatesUseCase: CurrenciesRatesUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CurrenciesRatesViewModel(currenciesRatesUseCase) as T
    }
}