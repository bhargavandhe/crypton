package com.bhargav.crypton.domain.repository

import com.bhargav.crypton.common.NativeCurrencies
import com.bhargav.crypton.common.Order
import com.bhargav.crypton.data.remote.dto.CoinDetailDto
import com.bhargav.crypton.data.remote.dto.CoinDto

interface CryptonRepository {

    suspend fun getCoins(
        currency: String = NativeCurrencies.INR.code,
        order: String = Order.MARKET_CAP_DESC.code,
        count: Int = 30,
        page: Int = 1
    ): List<CoinDto>

    suspend fun getCoinDetails(id: String): CoinDetailDto
}
