package com.bhargav.crypton.domain.model

import com.bhargav.crypton.data.remote.dto.DeveloperData
import com.bhargav.crypton.data.remote.dto.Image
import com.bhargav.crypton.data.remote.dto.Links
import com.bhargav.crypton.data.remote.dto.MarketData

data class CoinDetail(
    val id: String,
    val name: String,
    val image: Image,
    val symbol: String,
    val categories: List<String>,
    val communityScore: Double,
    val description: Map<String, String>,
    val developerData: DeveloperData?,
    val hashingAlgorithm: String?,
    val links: Links,
    val marketCapRank: Long,
    val marketData: MarketData?,
    val genesisDate: String?
)
