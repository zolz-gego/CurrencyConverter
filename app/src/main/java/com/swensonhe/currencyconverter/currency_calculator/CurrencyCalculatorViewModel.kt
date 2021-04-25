package com.swensonhe.currencyconverter.currency_calculator

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by George on 4/24/21.
 */
class CurrencyCalculatorViewModel(private val currencyCalculatorUseCase: CurrencyCalculatorUseCase) :
    ViewModel() {

    private val viewStateImpl = MutableLiveData<CurrencyCalculatorViewState>()
    val viewState: LiveData<CurrencyCalculatorViewState>

    init {
        viewStateImpl.value = CurrencyCalculatorViewState()
        viewState = viewStateImpl
    }

    private fun currentState() = viewStateImpl.value!!

    fun calculateRate(inputRate: String, sourceRate: Float) {
        val calculatedRate =
            currencyCalculatorUseCase.calculateRate(
                sourceRate = sourceRate,
                input = inputRate
            )

        viewStateImpl.value =
            currentState().copy(
                isCalculationDone = true,
                calculatedRate = calculatedRate.toString()
            )
    }
}