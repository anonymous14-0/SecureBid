package com.jemi.securebid.data.model

data class BidModel(
    val bidId: String = "",
    val auctionId: String = "",
    val bidderId: String = "",
    val amount: Long = 0,
    val timestamp: Long = 0
)