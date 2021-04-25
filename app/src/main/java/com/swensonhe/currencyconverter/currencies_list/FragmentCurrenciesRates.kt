package com.swensonhe.currencyconverter.currencies_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DividerItemDecoration
import com.swensonhe.currencyconverter.R
import com.swensonhe.currencyconverter.models.RatesModel
import kotlinx.android.synthetic.main.fragment_currencies_rates.*

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FragmentCurrenciesRates : Fragment() {

    private val viewModel: CurrenciesRatesViewModel by viewModels {
        CurrenciesRatesViewModelFactory(CurrenciesRatesInjection.inject(requireContext()))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_currencies_rates, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getCurrenciesRates(getString(R.string.default_currency))
        initializeObservers()
    }

    private fun initializeObservers() {
        viewModel.viewState.observe(requireActivity(), Observer { viewState ->
            viewState.apply {
                loading_shimmer.isVisible = isLoading

                if (isLoading) {
                    loading_shimmer.startShimmer()
                } else {
                    loading_shimmer.stopShimmer()
                }

                if (!isLoading && rates != null) {
                    fillRecyclerView(rates)
                }
            }
        })
    }

    private fun fillRecyclerView(rates: List<RatesModel>) {
        val ratesAdapter =
            CurrenciesRatesAdapter { ratesModel ->
                val dir =
                    FragmentCurrenciesRatesDirections.actionFirstFragmentToSecondFragment(
                        ratesModel
                    )

                findNavController().navigate(dir)
            }

        rv_currencies.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        rv_currencies.adapter = ratesAdapter

        ratesAdapter.submitList(rates)
    }
}