package com.bhargav.crypton.domain.model

data class Coin(
    val id: String,
    val name: String,
    val symbol: String,
    val image: String,
    val circulatingSupply: Double,
    val currentPrice: Double,
    val marketCap: Long,
    val totalSupply: Double,
    val totalVolume: Long,
    val priceChangePercentage24h: Double,
    val priceChangePercentage24hInCurrency: Double,
    val high24h: Double,
    val low24h: Double,
    val marketCapRank: Int,
)
