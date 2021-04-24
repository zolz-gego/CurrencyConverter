package com.swensonhe.currencyconverter.currencies_list

import com.swensonhe.currencyconverter.currencies_list.remote.CurrenciesRatesResponse

/**
 * Created by George on 4/24/21.
 */
class CurrenciesRatesUseCase(private val currenciesRatesRepository: CurrenciesRatesRepository) {

    suspend fun getCurrenciesRates(baseCurrency: String): CurrenciesRatesResponse {
        return currenciesRatesRepository.getCurrenciesRates(baseCurrency)
    }
}