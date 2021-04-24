package com.swensonhe.currencyconverter.currencies_list.remote

import com.squareup.moshi.Json

/**
 * Created by George on 4/24/21.
 */
data class CurrenciesRatesResponse(
    @Json(name = "success")
    var success: Boolean = true,
    @Json(name = "base")
    var base: String = "",
    @Json(name = "rates")
    var rates: HashMap<String, Float>
)