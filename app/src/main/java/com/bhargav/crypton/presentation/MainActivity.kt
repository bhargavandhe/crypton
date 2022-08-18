package com.bhargav.crypton.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.bhargav.crypton.presentation.ui.theme.CryptonTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptonTheme {
                Main()
            }
        }
    }
}

@Composable
fun Main() {
    Scaffold(
        topBar = { TopAppBar { Text(text = "Crypton", modifier = Modifier.padding(horizontal = 16.dp)) } }
    ) { paddingValues ->
        Navigator(navController = rememberNavController(), paddingValues = paddingValues)
    }
}
