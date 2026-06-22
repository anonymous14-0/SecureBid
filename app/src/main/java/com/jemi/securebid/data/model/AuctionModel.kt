package com.jemi.securebid.data.model

data class AuctionModel(
    val auctionId: String = "",
    val title: String = "",
    val description: String = "",
    val startPrice: Long = 0,
    val currentPrice: Long = 0,
    val sellerId: String = "",
    val status: String = "",
    val createdAt: Long = 0,
    val endTime: Long = 0
)