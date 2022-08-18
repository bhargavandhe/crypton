package com.bhargav.crypton.presentation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bhargav.crypton.presentation.calculator.CalculatorScreen
import com.bhargav.crypton.presentation.coin_detail.CoinDetailScreen
import com.bhargav.crypton.presentation.coin_list.CoinListScreen

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object CoinDetail : Routes("coin-detail")
    object Calculator : Routes("calculator")
}

@Composable
fun Navigator(navController: NavHostController, paddingValues: PaddingValues) {
    NavHost(navController = navController, startDestination = Routes.Home.route) {
        composable(route = Routes.Home.route) {
            CoinListScreen(navController = navController, paddingValues = paddingValues)
        }

        composable(route = Routes.CoinDetail.route + "/{coinId}") {
            CoinDetailScreen(navController = navController, paddingValues = paddingValues)
        }

        composable(route = Routes.Calculator.route) {
            CalculatorScreen(navController = navController, paddingValues = paddingValues)
        }
    }
}
