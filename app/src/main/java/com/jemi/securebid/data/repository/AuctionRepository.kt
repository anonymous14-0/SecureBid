package com.jemi.securebid.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.jemi.securebid.data.model.AuctionModel

class AuctionRepository {

    private val db = FirebaseFirestore.getInstance()

    fun createAuction(
        auction: AuctionModel,
        onSuccess: () -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        db.collection("auctions")
            .document(auction.auctionId)
            .set(auction)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener {
                onFailure(it)
            }
    }
    fun getAuctions(
        onSuccess: (List<AuctionModel>) -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        db.collection("auctions")
            .get()
            .addOnSuccessListener { result ->
                val auctions = result.toObjects(AuctionModel::class.java)
                onSuccess(auctions)
            }
            .addOnFailureListener {
                onFailure(it)
            }
    }
}