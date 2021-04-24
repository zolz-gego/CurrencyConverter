package com.swensonhe.currencyconverter.currencies_list

/**
 * Created by George on 4/24/21.
 */
data class CurrenciesRatesViewState(
    val isLoading: Boolean = false,
    val error: String? = null,
    val rates: HashMap<String, Float>? = null
)