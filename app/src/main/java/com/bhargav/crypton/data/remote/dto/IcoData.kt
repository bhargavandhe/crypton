package com.bhargav.crypton.data.remote.dto

import com.google.gson.annotations.SerializedName

data class IcoData(
    @SerializedName("ico_start_date")
    val icoStartDate: String? = null,
    @SerializedName("ico_end_date")
    val icoEndDate: String? = null,
    @SerializedName("short_desc")
    val shortDesc: String? = null,
    val description: String? = null,
    val links: IcoLinks? = null,
    @SerializedName("softcap_currency")
    val softcapCurrency: String? = null,
    @SerializedName("hardcap_currency")
    val hardcapCurrency: String? = null,
    @SerializedName("total_raised_currency")
    val totalRaisedCurrency: String? = null,
    @SerializedName("softcap_amount")
    val softcapAmount: Double?,
    @SerializedName("hardcap_amount")
    val hardcapAmount: Double?,
    @SerializedName("total_raised")
    val totalRaised: Double?,
    @SerializedName("quote_pre_sale_currency")
    val quotePreSaleCurrency: String? = null,
    @SerializedName("base_pre_sale_amount")
    val basePreSaleAmount: Double?,
    @SerializedName("quote_pre_sale_amount")
    val quotePreSaleAmount: Double?,
    @SerializedName("quote_public_sale_currency")
    val quotePublicSaleCurrency: String? = null,
    @SerializedName("base_public_sale_amount")
    val basePublicSaleAmount: String? = null,
    @SerializedName("quote_public_sale_amount")
    val quotePublicSaleAmount: String? = null,
    @SerializedName("accepting_currencies")
    val acceptingCurrencies: String? = null,
    @SerializedName("country_origin")
    val countryOrigin: String? = null,
    @SerializedName("pre_sale_start_date")
    val preSaleStartDate: String? = null,
    @SerializedName("pre_sale_end_date")
    val preSaleEndDate: String? = null,
    @SerializedName("whitelist_url")
    val whitelistUrl: String? = null,
    @SerializedName("whitelist_start_date")
    val whitelistStartDate: String? = null,
    @SerializedName("whitelist_end_date")
    val whitelistEndDate: String? = null,
    @SerializedName("bounty_detail_url")
    val bountyDetailUrl: String? = null,
    @SerializedName("amount_for_sale")
    val amountForSale: Double?,
    @SerializedName("kyc_required")
    val kycRequired: Boolean = false,
    @SerializedName("whitelist_available")
    val whitelistAvailable: Boolean?,
    @SerializedName("pre_sale_available")
    val preSaleAvailable: Boolean?,
    @SerializedName("pre_sale_ended")
    val preSaleEnded: Boolean = false
)
