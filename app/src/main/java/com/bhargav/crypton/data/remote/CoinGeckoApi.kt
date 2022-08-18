package com.bhargav.crypton.data.remote

import com.bhargav.crypton.data.remote.dto.CoinDetailDto
import com.bhargav.crypton.data.remote.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap

interface CoinGeckoApi {
    @GET("coins/markets")
    suspend fun getCoins(@QueryMap query: Map<String, String>): List<CoinDto>

    @GET("coins/{coinId}")
    suspend fun getCoinById(
        @Path("coinId") id: String,
        @QueryMap query: Map<String, String>
    ): CoinDetailDto
}
