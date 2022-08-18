package com.bhargav.crypton.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.bhargav.crypton.R

val ProductSans_Bold = Font(resId = R.font.product_sans_bold, weight = FontWeight.Bold)
val ProductSans_Bold_Italic =
    Font(resId = R.font.product_sans_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic)
val ProductSans_Light = Font(R.font.product_sans_light, weight = FontWeight.Light)
val ProductSans_Medium = Font(R.font.product_sans_medium, weight = FontWeight.Medium)
val ProductSans_Medium_Italic =
    Font(R.font.product_sans_medium_italic, weight = FontWeight.Medium, style = FontStyle.Italic)
val ProductSans_Regular = Font(R.font.product_sans_regular, weight = FontWeight.Normal)

val ProductSans = FontFamily(
    listOf(
        ProductSans_Light,
        ProductSans_Regular,
        ProductSans_Medium,
        ProductSans_Medium_Italic,
        ProductSans_Bold,
        ProductSans_Bold_Italic,
    )
)

val typography = Typography(
    h1 = TextStyle(
        fontFamily = ProductSans,
        fontWeight = FontWeight.Medium,
        fontSize = 102.sp,
        letterSpacing = (-1.5).sp,
    ),
    h2 = TextStyle(
        fontFamily = ProductSans,
        fontWeight = FontWeight.Medium,
        fontSize = 64.sp,
        letterSpacing = (-0.5).sp
    ),
    h3 = TextStyle(
        fontFamily = ProductSans,
        fontWeight = FontWeight.Medium,
        fontSize = 51.sp
    ),
    h4 = TextStyle(
        fontFamily = ProductSans,
        fontWeight = FontWeight.Medium,
        fontSize = 32.sp,
        letterSpacing = (0.25).sp
    ),
    h5 = TextStyle(
        fontFamily = ProductSans,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
    ),
    h6 = TextStyle(
        fontFamily = ProductSans,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        letterSpacing = (0.15).sp
    ),
    subtitle1 = TextStyle(
        fontFamily = ProductSans,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        letterSpacing = (0.15).sp

    ),
    subtitle2 = TextStyle(
        fontFamily = ProductSans,
        fontWeight = FontWeight.Normal,
        fontSize = 15.sp,
        letterSpacing = (0.1).sp
    ),
    body1 = TextStyle(
        fontFamily = ProductSans,
        fontWeight = FontWeight.Normal,
        fontSize = 17.sp,
        letterSpacing = (0.5).sp
    ),
    body2 = TextStyle(
        fontFamily = ProductSans,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = (0.25).sp
    ),
    button = TextStyle(
        fontFamily = ProductSans,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        letterSpacing = (1.25).sp
    ),
    caption = TextStyle(
        fontFamily = ProductSans,
        fontWeight = FontWeight.Normal,
        fontSize = 13.sp,
        letterSpacing = (0.4).sp,
    ),
    overline = TextStyle(
        fontFamily = ProductSans,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        letterSpacing = (1.5).sp,
    )
)
