package com.swensonhe.currencyconverter.currencies_list

import android.content.Context
import com.swensonhe.currencyconverter.remote.FixerIoAPI
import com.swensonhe.currencyconverter.remote.NetworkInjection

/**
 * Created by George on 4/24/21.
 */
object CurrenciesRatesInjection : NetworkInjection() {

    private fun provideRepository(context: Context): CurrenciesRatesRepository =
        CurrenciesRatesRepository(provideGetLoansRetrofitInterface(context))

    private fun provideGetLoansRetrofitInterface(context: Context): FixerIoAPI =
        provideStaticRetrofitInterface(context)
            .create(FixerIoAPI::class.java)

    private fun provideUseCase(currenciesRatesRepository: CurrenciesRatesRepository): CurrenciesRatesUseCase =
        CurrenciesRatesUseCase(currenciesRatesRepository)

    fun inject(context: Context) =
        provideUseCase(provideRepository(context))

}