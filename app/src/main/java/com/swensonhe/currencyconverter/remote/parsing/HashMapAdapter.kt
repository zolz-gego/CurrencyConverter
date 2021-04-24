package com.swensonhe.currencyconverter.remote.parsing

import com.squareup.moshi.FromJson


/**
 * Created by George on 4/24/21.
 */
class HashMapAdapter {

    @FromJson
    fun fromJson(json: MutableMap<String?, Float?>): MutableMap<String?, Float?> {
        val result = HashMap<String?, Float?>()
        for (key in json.keys) result[key] = json[key]
        return result
    }
}