package com.bhargav.crypton.common

import androidx.compose.ui.unit.dp

enum class Order(val code: String) {
    MARKET_CAP_DESC("market_cap_desc"),
    MARKET_CAP_ASC("market_cap_asc"),

    GECKO_DESC("gecko_desc"),
    GECKO_ASC("gecko_asc"),

    VOLUME_DESC("volume_desc"),
    VOLUME_ASC("volume_asc"),

    ID_DESC("id_desc"),
    ID_ASC("id_asc")
}

enum class NativeCurrencies(val code: String) {
    INR("inr"),
    USD("usd")
}

object Constants {
    const val BASE_URL = "https://api.coingecko.com/api/v3/"

    // passing data between routes
    const val PARAM_COIN_ID = "coinId"

    val INNER_PADDING = 24.dp
}
