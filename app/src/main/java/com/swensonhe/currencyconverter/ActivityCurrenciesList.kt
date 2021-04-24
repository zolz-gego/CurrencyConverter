package com.swensonhe.currencyconverter

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.swensonhe.currencyconverter.R

class ActivityCurrenciesList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currencies_list)
        setSupportActionBar(findViewById(R.id.toolbar))
    }

//    private fun setUpNavigation() {
//        val navHostFragment = supportFragmentManager
//            .findFragmentById(R.id.nav_host_container) as NavHostFragment
//        navController = navHostFragment.navController
//        val abc = AppBarConfiguration.Builder(navController.graph)
//            .build()
//        NavigationUI.setupActionBarWithNavController(this, navController, abc)
//        toolbar_main.setNavigationOnClickListener { v -> onBackPressed() }
//        bottom_nav.setOnNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.home -> performActionAfterSwitchingGraph(R.id.homeFragment)
//                R.id.marketplace -> performActionAfterSwitchingGraph(R.id.marketplaceFragment)
//                R.id.shipments -> performActionAfterSwitchingGraph(R.id.displayShipmentsFragment)
//                R.id.payment_history -> performActionAfterSwitchingGraph(R.id.paymentHistoryFragment)
//                R.id.more -> performActionAfterSwitchingGraph(R.id.more)
//            }
//            true
//        }
//
//    }
}