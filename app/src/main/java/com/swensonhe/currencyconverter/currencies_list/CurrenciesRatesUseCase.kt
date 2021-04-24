package com.swensonhe.currencyconverter.currencies_list

import com.swensonhe.currencyconverter.currencies_list.remote.CurrenciesRatesResponse
import com.swensonhe.currencyconverter.models.RatesModel

/**
 * Created by George on 4/24/21.
 */
class CurrenciesRatesUseCase(private val currenciesRatesRepository: CurrenciesRatesRepository) {

    suspend fun getCurrenciesRates(baseCurrency: String): CurrenciesRatesResponse {
        return currenciesRatesRepository.getCurrenciesRates(baseCurrency)
    }

    fun convertMapToList(ratesMap: MutableMap<String, Float>): List<RatesModel> =
        ratesMap.toList().map { RatesModel(it.first, it.second) }
}