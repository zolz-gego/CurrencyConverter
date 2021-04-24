package com.swensonhe.currencyconverter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ActivityCurrenciesList : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_activity_currencies_list)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}