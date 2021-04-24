package com.swensonhe.currencyconverter.currencies_list

import com.swensonhe.currencyconverter.utilities.FixerIoAPI

/**
 * Created by George on 4/24/21.
 */
class CurrenciesRatesRepository(private val api: FixerIoAPI) {

    suspend fun getCurrenciesRates(baseCurrency: String) {
        api.getCurrencies(baseCurrency = baseCurrency)
    }
}