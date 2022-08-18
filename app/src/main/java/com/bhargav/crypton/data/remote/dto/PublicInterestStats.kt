package com.bhargav.crypton.data.remote.dto

import com.google.gson.annotations.SerializedName


data class PublicInterestStats(
    @SerializedName("alexa_rank")
    val alexaRank: Long? = 0,
    @SerializedName("bing_matches")
    val bingMatches: Long? = 0
)
