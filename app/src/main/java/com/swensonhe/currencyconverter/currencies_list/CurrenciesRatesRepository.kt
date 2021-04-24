package com.swensonhe.currencyconverter.currencies_list

import com.swensonhe.currencyconverter.currencies_list.remote.CurrenciesRatesResponse
import com.swensonhe.currencyconverter.remote.FixerIoAPI

/**
 * Created by George on 4/24/21.
 */
class CurrenciesRatesRepository(private val api: FixerIoAPI) {

    suspend fun getCurrenciesRates(baseCurrency: String):CurrenciesRatesResponse {
        return api.getCurrencies(baseCurrency = baseCurrency)
    }
}