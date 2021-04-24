package com.swensonhe.currencyconverter.currency_calculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.swensonhe.currencyconverter.R
import com.swensonhe.currencyconverter.models.RatesModel
import kotlinx.android.synthetic.main.fragment_currency_calculator.*

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class FragmentCurrencyCalculator : Fragment() {

    private var ratesModel: RatesModel? = RatesModel()

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
//        et_converted_currency.hint = ratesModel?.currency

        view.findViewById<Button>(R.id.button_second).setOnClickListener {
//            findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
        }
    }

    fun getExtras() {
        arguments?.let {
            ratesModel = FragmentCurrencyCalculatorArgs.fromBundle(it).ratesModel
            et_converted_currency.setText(ratesModel!!.currency)
        }

//        val args = FragmentCurrencyCalculatorArgs.fromBundle(bundle = bundle!!)
//        ratesModel = args?.ratesModel


    }
}