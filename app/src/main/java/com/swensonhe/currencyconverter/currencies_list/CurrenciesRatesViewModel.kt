package com.swensonhe.currencyconverter.currencies_list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * Created by George on 4/24/21.
 */
class CurrenciesRatesViewModel(private val currenciesRatesUseCase: CurrenciesRatesUseCase) :
    ViewModel() {

    private val viewStateImpl = MutableLiveData<CurrenciesRatesViewState>()
    val viewState: LiveData<CurrenciesRatesViewState>

    init {
        viewStateImpl.value = CurrenciesRatesViewState()
        viewState = viewStateImpl
    }

    private fun currentState() = viewStateImpl.value!!

    fun getCurrenciesRates(baseCurrency: String) {
        viewStateImpl.value = currentState().copy(isLoading = true)

        viewModelScope.launch {

            val rates = currenciesRatesUseCase.getCurrenciesRates(baseCurrency)

            viewStateImpl.value = currentState().copy(
            )
        }

    }
}