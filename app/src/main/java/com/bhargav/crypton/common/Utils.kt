package com.bhargav.crypton.common

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.compose.ui.graphics.Color
import androidx.palette.graphics.Palette
import java.text.NumberFormat
import java.util.*

val locale = Locale("en", "IN")

fun Number.toCurrency(): String = NumberFormat.getCurrencyInstance(locale).format(this)

fun Number.round(digits: Int) = String.format("%.${digits}f", this)

fun Double.toCompactCurrency() = "₹" + when {
    this < 1e3 -> this.toString()
    this >= 1e3 && this < 1e6 -> (this / 1e3).round(1) + " thousand"
    this >= 1e6 && this < 1e9 -> (this / 1e6).round(1) + " million"
    this >= 1e9 && this < 1e12 -> (this / 1e9).round(1) + " billion"
    this >= 1e12 -> (this / 1e12).round(1) + " trillion"
    else -> ""
}

fun calcDominantColor(drawable: Drawable, onFinish: (Color) -> Unit): Unit? {
    Palette.from((drawable as BitmapDrawable).bitmap.copy(Bitmap.Config.ARGB_8888, true))
        .generate { palette -> palette?.dominantSwatch?.rgb?.let { onFinish(Color(it)) } }
    return null
}
