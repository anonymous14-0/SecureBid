package com.jemi.securebid.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jemi.securebid.data.model.AuctionModel
import com.jemi.securebid.data.repository.AuctionRepository

@Composable
fun AuctionListScreen() {

    val repository = remember { AuctionRepository() }
    var auctionList by remember { mutableStateOf<List<AuctionModel>>(emptyList()) }

    LaunchedEffect(Unit) {
        repository.getAuctions(
            onSuccess = {
                auctionList = it
            },
            onFailure = {
                println(it.message)
            }
        )
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(auctionList) { auction ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = auction.title,
                        style = MaterialTheme.typography.titleLarge
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text("Harga: Rp ${auction.currentPrice}")
                    Text("Status: ${auction.status}")
                }
            }
        }
    }
}