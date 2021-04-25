package com.swensonhe.currencyconverter.currency_calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.jakewharton.rxbinding2.widget.RxTextView
import com.swensonhe.currencyconverter.R
import com.swensonhe.currencyconverter.models.RatesModel
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import kotlinx.android.synthetic.main.fragment_currency_calculator.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class FragmentCurrencyCalculator : Fragment() {

    private val compositeDisposable = CompositeDisposable()
    private var ratesModel: RatesModel? = RatesModel()

    private val viewModel: CurrencyCalculatorViewModel by viewModels {
        CurrencyCalculatorViewModelFactory(CurrencyCalculatorInjection.inject())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_currency_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getExtras()

        til_converted_currency.hint = ratesModel!!.currency
        et_converted_currency.setText(ratesModel!!.rate.toString())

        initializeObservers()
        controlTextChanged()
    }

    fun getExtras() {
        arguments?.let {
            ratesModel = FragmentCurrencyCalculatorArgs.fromBundle(it).ratesModel
        }
    }

    private fun initializeObservers() {
        viewModel.viewState.observe(requireActivity(), Observer { viewState ->
            viewState.apply {

                if (isCalculationDone && !calculatedRate.isNullOrEmpty()) {
                    et_converted_currency.setText(calculatedRate)
                }
            }
        })
    }

    private fun controlTextChanged() {
        compositeDisposable.add(textChanges(et_default_currency).subscribe {
            textChanged(it.toString())
        })
    }

    private fun textChanged(inputString: String) {
        viewModel.calculateRate(inputRate = inputString, sourceRate = ratesModel!!.rate)
    }

    private fun textChanges(editText: EditText): Observable<String> {
        return RxTextView.textChanges(editText)
            .skipInitialValue()
            .map { it.toString() }
    }
}