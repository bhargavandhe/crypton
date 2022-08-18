package com.bhargav.crypton.data.remote.dto

data class Image(
    val thumb: String,
    val small: String,
    val large: String? = null,
)
