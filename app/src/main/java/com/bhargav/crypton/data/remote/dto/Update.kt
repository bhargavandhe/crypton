package com.bhargav.crypton.data.remote.dto

import com.google.gson.annotations.SerializedName

data class Update(
    val description: String? = null,
    val category: String? = null,
    @SerializedName("created_at")
    val createdAt: String? = null,
    val user: String? = null,
    @SerializedName("user_title")
    val userTitle: String? = null,
    val pin: Boolean = false,
    val project: Project? = null
)
