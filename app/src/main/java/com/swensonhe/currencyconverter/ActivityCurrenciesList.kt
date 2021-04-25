package com.swensonhe.currencyconverter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment

class ActivityCurrenciesList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_activity_currencies_list)
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun onBackPressed() {
        onSupportNavigateUp()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavControllerFromFragmentContainer()
        return when (navController.currentDestination?.id) {
            R.id.currencyCalculatorFragment -> {
                navController.popBackStack(R.id.currencyCalculatorFragment, true)
                true
            }
            else -> return navController.navigateUp() || super.onSupportNavigateUp()
        }

    }

    private fun findNavControllerFromFragmentContainer(): NavController {
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_container) as NavHostFragment
        return navHostFragment.navController
    }
}