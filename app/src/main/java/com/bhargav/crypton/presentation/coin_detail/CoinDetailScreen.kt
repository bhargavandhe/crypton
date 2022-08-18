package com.bhargav.crypton.presentation.coin_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.bhargav.crypton.common.*
import com.bhargav.crypton.data.remote.dto.MarketData
import com.bhargav.crypton.presentation.ui.theme.Danger
import com.bhargav.crypton.presentation.ui.theme.Success
import kotlin.math.absoluteValue

private const val TAG = "CoinDetailScreen"

@Composable
fun CoinDetailScreen(
    navController: NavController,
    viewModel: CoinDetailViewModel = hiltViewModel(),
    paddingValues: PaddingValues
) {
    val state = viewModel.state.value
    var isFavorite by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        when {
            state.isLoading -> CircularProgressIndicator(modifier = Modifier.align(CenterHorizontally))
            state.error != "" -> Text(text = state.error)
            state.coinData != null -> {
                val coinData = state.coinData

                IconButton(
                    onClick = { navController.popBackStack() },
                    content = {
                        Icon(imageVector = Icons.Rounded.ArrowBack, contentDescription = "previous")
                    }
                )

                Column(
                    Modifier
                        .padding(horizontal = Constants.INNER_PADDING)
                        .fillMaxSize()
                        .verticalScroll(state = rememberScrollState())
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = rememberImagePainter(coinData.image.large),
                            contentDescription = "logo",
                            modifier = Modifier.size(64.dp)
                        )

                        Column(modifier = Modifier.padding(start = Constants.INNER_PADDING)) {
                            Text(
                                text = coinData.name + " price",
                                color = MaterialTheme.colors.onBackground.copy(alpha = 0.7f),
                                style = MaterialTheme.typography.body1
                            )
                            Text(
                                text = coinData.marketData?.currentPrice?.get(NativeCurrencies.INR.code)
                                    ?.toCurrency()!!,
                                style = MaterialTheme.typography.h5,
                            )
                            Text(
                                text = "${
                                    (coinData.marketData.high24h[NativeCurrencies.INR.code]!! - coinData
                                        .marketData.low24h[NativeCurrencies.INR.code]!!).toCurrency()
                                } (${
                                    coinData.marketData
                                        .priceChangePercentage24h
                                        .absoluteValue.round(2)
                                }%)",
                                color = if (coinData.marketData.priceChangePercentage24h > 0) MaterialTheme.colors.Success
                                else MaterialTheme.colors.Danger,
                                style = MaterialTheme.typography.body2
                            )
                        }

                        Row(modifier = Modifier.weight(1f), horizontalArrangement = Arrangement.End) {
                            IconButton(onClick = { isFavorite = !isFavorite }) {
                                Icon(
                                    imageVector = Icons.Rounded.Favorite,
                                    contentDescription = "favorite",
                                    tint = if (isFavorite) Color.Red else MaterialTheme.colors.onBackground
                                )
                            }

                            IconButton(onClick = { }) {
                                Icon(
                                    imageVector = Icons.Rounded.Share,
                                    contentDescription = "share",
                                )
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    MarketDataSection(marketData = coinData.marketData ?: MarketData())

                    val description = coinData.description["en"]?.replace(regex = Regex("<a[^>]*>|</a>"), "")
                    if (description != null && description != "") DescriptionSection(
                        coinName = coinData.name,
                        description = description
                    )

                    if (coinData.genesisDate != null && coinData.genesisDate != "")
                        Text(text = "Released on – ${coinData.genesisDate}")
                }
            }
        }
    }
}

@Composable
fun MarketStatItem(
    imageVector: ImageVector,
    title: @Composable RowScope.() -> Unit,
    subtitle: @Composable RowScope.() -> Unit
) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 12.dp),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = imageVector, contentDescription = "icon", tint = MaterialTheme.colors.secondary)
        Spacer(modifier = Modifier.width(8.dp))
        title()
    }

    subtitle()
}

@Composable
fun MarketDataSection(marketData: MarketData) {
    Text(text = "Market Data", style = MaterialTheme.typography.h5)
    Spacer(modifier = Modifier.height(8.dp))

    val marketCapital: String? = marketData.marketCap?.get(NativeCurrencies.INR.code)?.toCompactCurrency()
    val high24h: String? = marketData.high24h[NativeCurrencies.INR.code]?.toCompactCurrency()
    val low24h: String? = marketData.low24h[NativeCurrencies.INR.code]?.toCompactCurrency()
    val totalVolume: String? = marketData.totalVolume?.get(NativeCurrencies.INR.code)?.toCompactCurrency()
    val circulatingSupply: String = marketData.circulatingSupply.toCompactCurrency()

    MarketStatItem(
        imageVector = Icons.Rounded.TrendingUp,
        title = { Text(text = "24hr high") },
        subtitle = { Text(text = high24h ?: "", textAlign = TextAlign.End) }
    )

    MarketStatItem(
        imageVector = Icons.Rounded.TrendingDown,
        title = { Text(text = "24hr low") },
        subtitle = { Text(text = low24h ?: "", textAlign = TextAlign.End) }
    )

    MarketStatItem(
        imageVector = Icons.Rounded.DataSaverOff,
        title = { Text(text = "Market Capital") },
        subtitle = { Text(text = marketCapital ?: "", textAlign = TextAlign.End) }
    )

    MarketStatItem(
        imageVector = Icons.Rounded.BarChart,
        title = { Text(text = "Volume") },
        subtitle = { Text(text = totalVolume ?: "0", textAlign = TextAlign.End) }
    )

    MarketStatItem(
        imageVector = Icons.Rounded.ChangeCircle,
        title = { Text(text = "Circulating Supply") },
        subtitle = { Text(text = circulatingSupply, textAlign = TextAlign.End) }
    )

    MarketStatItem(
        imageVector = Icons.Rounded.Tag,
        title = { Text(text = "Market Cap rank") },
        subtitle = { Text(text = "#${marketData.marketCapRank}", textAlign = TextAlign.End) }
    )
}

@Composable
fun DescriptionSection(coinName: String, description: String) {
    Text(text = "About $coinName", style = MaterialTheme.typography.h5)
    Spacer(modifier = Modifier.height(8.dp))
    SelectionContainer {
        Text(text = description, color = MaterialTheme.colors.onBackground.copy(alpha = 0.7f))
    }
}
