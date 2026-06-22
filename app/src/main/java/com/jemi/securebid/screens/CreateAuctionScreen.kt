package com.jemi.securebid.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.firebase.auth.FirebaseAuth
import com.jemi.securebid.data.model.AuctionModel
import com.jemi.securebid.data.repository.AuctionRepository
import java.util.UUID

@Composable
fun CreateAuctionScreen() {

    val repository = remember { AuctionRepository() }

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var startPrice by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Create Auction",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Nama Barang") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Deskripsi") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = startPrice,
            onValueChange = { startPrice = it },
            label = { Text("Harga Awal") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {

                val sellerId = FirebaseAuth.getInstance().currentUser?.uid ?: return@Button
                val auctionId = UUID.randomUUID().toString()

                val currentTime = System.currentTimeMillis()
                val endTime = currentTime + (24 * 60 * 60 * 1000)

                val auction = AuctionModel(
                    auctionId = auctionId,
                    title = title,
                    description = description,
                    startPrice = startPrice.toLong(),
                    currentPrice = startPrice.toLong(),
                    sellerId = sellerId,
                    status = "OPEN",
                    createdAt = currentTime,
                    endTime = endTime
                )

                repository.createAuction(
                    auction,
                    onSuccess = {
                        println("Auction berhasil dibuat")
                    },
                    onFailure = {
                        println(it.message)
                    }
                )
            }
        ) {
            Text("Buat Auction")
        }
    }
}