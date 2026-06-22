package com.jemi.securebid.data.model

data class TransactionModel(
    val transactionId: String = "",
    val auctionId: String = "",
    val buyerId: String = "",
    val sellerId: String = "",
    val amount: Long = 0,
    val status: String = ""
)