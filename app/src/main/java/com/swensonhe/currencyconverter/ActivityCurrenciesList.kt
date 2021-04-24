package com.swensonhe.currencyconverter

import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.swensonhe.currencyconverter.R

class ActivityCurrenciesList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_currencies_list)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}