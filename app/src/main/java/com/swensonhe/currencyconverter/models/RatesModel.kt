package com.swensonhe.currencyconverter.models

import android.os.Parcelable
import androidx.recyclerview.widget.DiffUtil
import kotlinx.android.parcel.Parcelize

/**
 * Created by George on 4/24/21.
 */
@Parcelize
data class RatesModel(
    var currency: String = "",
    var rate: Float = 0F
) : Parcelable {
    companion object {
        val DIFF_UTIL = object : DiffUtil.ItemCallback<RatesModel>() {
            override fun areItemsTheSame(oldItem: RatesModel, newItem: RatesModel): Boolean {
                return oldItem.currency.equals(newItem.currency, true)
            }

            override fun areContentsTheSame(oldItem: RatesModel, newItem: RatesModel): Boolean {
                return oldItem == newItem
            }

        }
    }
}