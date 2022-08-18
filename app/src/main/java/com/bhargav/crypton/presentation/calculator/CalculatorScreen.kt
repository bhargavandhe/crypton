package com.bhargav.crypton.presentation.calculator

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

@Composable
fun CalculatorScreen(
    navController: NavHostController,
    paddingValues: PaddingValues
) {
    Column {
        Text(text = "Return Calculator", style = MaterialTheme.typography.h4)

    }
}
