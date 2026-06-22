package com.jemi.securebid.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Selamat datang di SecureBid",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                navController.navigate("create_auction")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Buat Auction")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                navController.navigate("auction_list")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Lihat Auction")
        }
    }
}