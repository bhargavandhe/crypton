package com.bhargav.crypton.data.remote.dto

import com.bhargav.crypton.domain.model.CoinDetail
import com.google.gson.annotations.SerializedName


data class CoinDetailDto(
    val id: String,
    val symbol: String,
    val name: String,
    @SerializedName("hashing_algorithm")
    val hashingAlgorithm: String? = null,
    @SerializedName("block_time_in_minutes")
    val blockTimeInMinutes: Long = 0,
    val categories: List<String>,
    val localization: Map<String, String>,
    val description: Map<String, String>,
    val links: Links,
    val image: Image,
    @SerializedName("country_origin")
    val countryOrigin: String? = null,
    @SerializedName("genesis_date")
    val genesisDate: String? = null,
    @SerializedName("contract_address")
    val contractAddress: String? = null,
    @SerializedName("ico_data")
    val icoData: IcoData? = null,
    @SerializedName("market_cap_rank")
    val marketCapRank: Long = 0,
    @SerializedName("coingecko_rank")
    val coingeckoRank: Long = 0,
    @SerializedName("coingecko_score")
    val coingeckoScore: Double = 0.0,
    @SerializedName("developer_score")
    val developerScore: Double = 0.0,
    @SerializedName("community_score")
    val communityScore: Double = 0.0,
    @SerializedName("liquidity_score")
    val liquidityScore: Double = 0.0,
    @SerializedName("public_interest_score")
    val publicInterestScore: Double = 0.0,
    @SerializedName("market_data")
    val marketData: MarketData? = null,
    @SerializedName("community_data")
    val communityData: CommunityData? = null,
    @SerializedName("developer_data")
    val developerData: DeveloperData? = null,
    @SerializedName("public_interest_stats")
    val publicInterestStats: PublicInterestStats? = null,
    @SerializedName("status_updates")
    val statusUpdates: List<Update>? = null,
    @SerializedName("last_updated")
    val lastUpdated: String? = null,
    val tickers: List<Ticker>? = null,
    @SerializedName("sentiment_votes_up_percentage")
    val sentimentVotesUpPercentage: Float = 50f,
    @SerializedName("sentiment_votes_down_percentage")
    val sentimentVotesDownPercentage: Float = 50f,
    @SerializedName("asset_platform_id")
    val assetPlatformId: String?,
    val platforms: Map<String, String> = emptyMap(),
    @SerializedName("public_notice")
    val publicNotice: String? = null,
    @SerializedName("additional_notices")
    val additionalNotices: List<String> = emptyList(),
) {

    fun toCoinDetail() = CoinDetail(
        id = id,
        name = name,
        image = image,
        symbol = symbol,
        categories = categories,
        communityScore = communityScore,
        description = description,
        developerData = developerData,
        hashingAlgorithm = hashingAlgorithm,
        links = links,
        marketCapRank = marketCapRank,
        marketData = marketData,
        genesisDate = genesisDate
    )
}
