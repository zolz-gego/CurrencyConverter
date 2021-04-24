package com.swensonhe.currencyconverter.currency_calculator

/**
 * Created by George on 4/24/21.
 */
data class CurrencyCalculatorViewState(
    val isCalculationDone:Boolean = false,
    val calculatedRate: String? = null
)