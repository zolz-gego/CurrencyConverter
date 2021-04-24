package com.swensonhe.currencyconverter.utilities

import retrofit2.http.Body
import retrofit2.http.GET

/**
 * Created by George on 4/24/21.
 */
interface FixerIoAPI {
    @GET("http://data.fixer.io/api/latest")
    suspend fun getCurrencies(@Body baseCurrency:String)
}