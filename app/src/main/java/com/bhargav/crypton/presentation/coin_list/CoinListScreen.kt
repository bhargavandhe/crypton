package com.bhargav.crypton.presentation.coin_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bhargav.crypton.common.Constants
import com.bhargav.crypton.domain.model.Coin
import com.bhargav.crypton.presentation.Routes
import com.bhargav.crypton.presentation.coin_list.components.CoinListItem
import com.bhargav.crypton.presentation.coin_list.components.FavoriteCoinItem

private const val TAG = "CoinListScreen"

@Composable
fun CoinListScreen(
    navController: NavController,
    viewModel: CoinListViewModel = hiltViewModel(),
    paddingValues: PaddingValues
) {
    val coinState = viewModel.state.value
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
    ) {
        when {
            coinState.isLoading -> CircularProgressIndicator(
                modifier = Modifier.align(CenterHorizontally)
            )
            coinState.error != "" -> Text(text = coinState.error)
            coinState.coins.isNotEmpty() -> {
                FavoritesSection(navController = navController, favorites = coinState.coins.subList(0, 5))

                CoinList(navController = navController, coins = coinState.coins)
            }
        }
    }
}

@Composable
fun FavoritesSection(navController: NavController, favorites: List<Coin>) {
    Text(
        text = "Favorites",
        style = MaterialTheme.typography.h5,
        modifier = Modifier.padding(start = Constants.INNER_PADDING, top = 12.dp)
    )
    LazyRow(state = rememberLazyListState(), contentPadding = PaddingValues(16.dp)) {
        items(items = favorites) { coin ->
            FavoriteCoinItem(
                coin = coin,
                onClick = { navController.navigate(Routes.CoinDetail.route + "/${coin.id}") }
            )
        }
    }
}

@Composable
fun CoinList(navController: NavController, coins: List<Coin>) {
    coins.mapIndexed { index, coin ->
        CoinListItem(
            coin = coin,
            onClick = { navController.navigate(Routes.CoinDetail.route + "/${coin.id}") }
        )
        if (index < coins.size) Divider()
    }
}
