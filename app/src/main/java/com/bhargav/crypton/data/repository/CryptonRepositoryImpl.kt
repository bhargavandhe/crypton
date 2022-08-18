package com.bhargav.crypton.data.repository

import com.bhargav.crypton.data.remote.CoinGeckoApi
import com.bhargav.crypton.data.remote.dto.CoinDetailDto
import com.bhargav.crypton.data.remote.dto.CoinDto
import com.bhargav.crypton.domain.repository.CryptonRepository
import javax.inject.Inject

private const val TAG = "CryptonRepositoryImpl"

class CryptonRepositoryImpl @Inject constructor(private val api: CoinGeckoApi) : CryptonRepository {

    override suspend fun getCoins(currency: String, order: String, count: Int, page: Int): List<CoinDto> =
        api.getCoins(
            query = mapOf(
                "vs_currency" to currency,
                "order" to order,
                "per_page" to count.toString(),
                "page" to page.toString(),
                "sparkline" to false.toString(),
                "price_change_percentage" to "24h"
            )
        )

    override suspend fun getCoinDetails(id: String): CoinDetailDto = api.getCoinById(
        id = id, query = mapOf(
            "localization" to false.toString(),
            "tickers" to false.toString(),
            "market_data" to true.toString(),
            "community_data" to false.toString(),
            "sparkline" to false.toString(),
        )
    )

}
