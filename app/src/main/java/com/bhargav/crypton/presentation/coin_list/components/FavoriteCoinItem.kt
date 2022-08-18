package com.bhargav.crypton.presentation.coin_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import coil.compose.rememberImagePainter
import com.bhargav.crypton.common.round
import com.bhargav.crypton.common.toCurrency
import com.bhargav.crypton.domain.model.Coin
import com.bhargav.crypton.presentation.ui.theme.Danger
import com.bhargav.crypton.presentation.ui.theme.Success

@Composable
fun FavoriteCoinItem(coin: Coin, onClick: () -> Unit) {
    ConstraintLayout(
        modifier = Modifier
            .padding(end = 16.dp)
            .size(142.dp)
            .clip(shape = MaterialTheme.shapes.large)
            .background(color = Color.White.copy(alpha = 0.1f))
            .clickable { onClick.invoke() }
    ) {
        val (header, body, footer) = createRefs()

        Image(
            painter = rememberImagePainter(
                data = coin.image,
                builder = { crossfade(true) }
            ),
            contentDescription = "logo",
            modifier = Modifier
                .padding(16.dp)
                .size(36.dp)
                .clip(CircleShape)
                .constrainAs(header) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                }
        )

        Column(
            modifier = Modifier
                .constrainAs(body) {
                    bottom.linkTo(footer.top, margin = 8.dp)
                    start.linkTo(parent.start)
                }
                .padding(start = 16.dp)
        ) {
            Text(text = coin.name, style = MaterialTheme.typography.h5.copy(fontSize = 16.sp))
            Row {
                Text(
                    text = coin.symbol.uppercase(),
                    style = MaterialTheme.typography.caption,
                    color = MaterialTheme.colors.onSurface.copy(alpha = 0.7f)
                )

                Text(
                    text = coin.priceChangePercentage24h.round(2),
                    style = MaterialTheme.typography.caption,
                    color = if (coin.priceChangePercentage24h > 0) MaterialTheme.colors.Success
                    else MaterialTheme.colors.Danger
                )
            }
        }

        Row(
            modifier = Modifier
                .constrainAs(footer) {
                    bottom.linkTo(parent.bottom)
                    end.linkTo(parent.end)
                }
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                .background(color = Color.White.copy(alpha = 0.1f))
                .padding(vertical = 8.dp, horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            content = {
                Text(
                    text = coin.currentPrice.toCurrency(),
                    style = MaterialTheme.typography.h5.copy(fontSize = 14.sp)
                )
            }
        )
    }
}
