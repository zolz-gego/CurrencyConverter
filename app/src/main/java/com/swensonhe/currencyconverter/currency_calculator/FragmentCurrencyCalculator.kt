package com.swensonhe.currencyconverter.currency_calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.swensonhe.currencyconverter.R
import com.swensonhe.currencyconverter.models.RatesModel
import kotlinx.android.synthetic.main.fragment_currency_calculator.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class FragmentCurrencyCalculator : Fragment() {

    private var ratesModel: RatesModel? = RatesModel()

    private val viewModel: CurrencyCalculatorViewModel by viewModels {
        CurrencyCalculatorViewModelFactory(CurrencyCalculatorInjection.inject())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_currency_calculator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        getExtras()

        et_converted_currency.setHint(ratesModel!!.currency)
        et_converted_currency.setText(ratesModel!!.rate.toString())

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    fun getExtras() {
        arguments?.let {
            ratesModel = FragmentCurrencyCalculatorArgs.fromBundle(it).ratesModel
        }
    }
}