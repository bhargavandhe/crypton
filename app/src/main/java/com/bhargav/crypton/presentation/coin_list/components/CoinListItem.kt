package com.bhargav.crypton.presentation.coin_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.bhargav.crypton.common.round
import com.bhargav.crypton.common.toCurrency
import com.bhargav.crypton.domain.model.Coin
import com.bhargav.crypton.presentation.ui.theme.Danger
import com.bhargav.crypton.presentation.ui.theme.Success

@Composable
fun CoinListItem(
    coin: Coin,
    onClick: () -> Unit = { }
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick.invoke() }
            .padding(horizontal = 24.dp, vertical = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberImagePainter(data = coin.image),
            contentDescription = "logo",
            modifier = Modifier
                .size(32.dp)
                .clip(CircleShape)
        )
        Row(
            modifier = Modifier
                .padding(start = 16.dp)
                .weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = coin.name, style = MaterialTheme.typography.h6)
                Text(
                    text = coin.symbol.uppercase(),
                    style = MaterialTheme.typography.subtitle2,
                    color = MaterialTheme.colors.onBackground.copy(alpha = 0.7f)
                )
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(
                    text = coin.currentPrice.toCurrency(),
                    style = MaterialTheme.typography.body1,
                )
                Text(
                    text = "${coin.priceChangePercentage24h.round(2)}%",
                    style = MaterialTheme.typography.body2,
                    color = if (coin.priceChangePercentage24h > 0) MaterialTheme.colors.Success
                    else MaterialTheme.colors.Danger,
                )
            }
        }
    }
}
