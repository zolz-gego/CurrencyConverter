package com.swensonhe.currencyconverter.currency_calculator

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by George on 4/24/21.
 */
class CurrencyCalculatorViewModelFactory(private val currencyCalculatorUseCase: CurrencyCalculatorUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CurrencyCalculatorViewModel(currencyCalculatorUseCase) as T
    }
}