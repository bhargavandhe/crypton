package com.bhargav.crypton.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Ticker(
    val base: String,
    val target: String,
    val market: Market,
    val last: Double = 0.0,
    val volume: Double = 0.0,
    @SerializedName("converted_last")
    val convertedLast: Map<String, String> = emptyMap(),
    @SerializedName("converted_volume")
    val convertedVolume: Map<String, String> = emptyMap(),
    @SerializedName("trust_score")
    val trustScore: String?,
    @SerializedName("bid_ask_spread_percentage")
    val bidAskSpreadPercentage: Double?,
    val timestamp: String,
    @SerializedName("last_traded_at")
    val lastTradedAt: String,
    @SerializedName("last_fetch_at")
    val lastFetchAt: String,
    @SerializedName("is_anomaly")
    val isAnomaly: Boolean = false,
    @SerializedName("is_stale")
    val isStale: Boolean = false,
    @SerializedName("trade_url")
    val tradeUrl: String? = null,
    @SerializedName("coin_id")
    val coinId: String,
    @SerializedName("token_info_url")
    val tokenInfoUrl: String?,
    @SerializedName("target_coin_id")
    val targetCoinId: String? = null,
)
