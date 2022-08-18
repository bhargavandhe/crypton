package com.bhargav.crypton.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CommunityData(
    @SerializedName("facebook_likes")
    val facebookLikes: Double = 0.0,
    @SerializedName("twitter_followers")
    val twitterFollowers: Double = 0.0,
    @SerializedName("reddit_average_posts_48h")
    val redditAveragePosts48h: Double = 0.0,
    @SerializedName("reddit_average_comments_48h")
    val redditAverageComments48h: Double = 0.0,
    @SerializedName("reddit_subscribers")
    val redditSubscribers: Double = 0.0,
    @SerializedName("reddit_accounts_active_48h")
    val redditAccountsActive48h: Double = 0.0,
    @SerializedName("telegram_channel_user_count")
    val telegramChannelUserCount: Double? = null,
)
