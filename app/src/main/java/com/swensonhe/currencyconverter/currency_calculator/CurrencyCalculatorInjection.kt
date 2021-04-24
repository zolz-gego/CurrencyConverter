package com.swensonhe.currencyconverter.currency_calculator

/**
 * Created by George on 4/24/21.
 */
object CurrencyCalculatorInjection {

    private fun provideUseCase(): CurrencyCalculatorUseCase =
        CurrencyCalculatorUseCase()

    fun inject() =
        provideUseCase()
}