package com.bhargav.crypton.data.remote.dto

import com.google.gson.annotations.SerializedName

data class DeveloperData(
    val forks: Long = 0,
    val stars: Long = 0,
    val subscribers: Long = 0,
    @SerializedName("total_issues")
    val totalIssues: Long = 0,
    @SerializedName("closed_issues")
    val closedIssues: Long = 0,
    @SerializedName("pull_requests_merged")
    val pullRequestsMerged: Long = 0,
    @SerializedName("pull_request_contributors")
    val pullRequestContributors: Long = 0,
    @SerializedName("code_additions_deletions_4_weeks")
    val codeAdditionsDeletions4Weeks: CodeAdditionsDeletions4Weeks? = null,
    @SerializedName("commit_count_4_weeks")
    val commitCount4Weeks: Long = 0,
    @SerializedName("last_4_weeks_commit_activity_series")
    val last4WeeksCommitActivitySeries: List<Long>? = null
)
