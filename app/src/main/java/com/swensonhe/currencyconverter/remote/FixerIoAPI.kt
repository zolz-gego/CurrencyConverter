package com.swensonhe.currencyconverter.remote

import com.swensonhe.currencyconverter.currencies_list.remote.CurrenciesRatesResponse
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by George on 4/24/21.
 */
interface FixerIoAPI {
    @GET("api/latest")
    suspend fun getCurrencies(
        @Query("access_key") accessKey: String,
        @Query("base") baseCurrency: String
    ): CurrenciesRatesResponse
}