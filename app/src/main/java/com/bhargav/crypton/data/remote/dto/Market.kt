package com.bhargav.crypton.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Market(
    val name: String,
    val identifier: String,
    @SerializedName("has_trading_incentive")
    val hasTradingIncentive: Boolean = false
)
