package com.swensonhe.currencyconverter.currency_calculator

/**
 * Created by George on 4/24/21.
 */
class CurrencyCalculatorUseCase {

    fun calculateRate(sourceRate: Float, input: String): String {
        if (input.isEmpty()) {
            return "0"
        }

        val inputRate = input.toFloat()

        return (sourceRate * inputRate).toString()
    }
}