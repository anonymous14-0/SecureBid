package com.jemi.securebid.data.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.jemi.securebid.data.model.UserModel

class UserRepository {

    private val db = FirebaseFirestore.getInstance()

    fun saveUser(
        user: UserModel,
        onSuccess: () -> Unit,
        onFailure: (Exception) -> Unit
    ) {
        db.collection("users")
            .document(user.uid)
            .set(user)
            .addOnSuccessListener {
                onSuccess()
            }
            .addOnFailureListener {
                onFailure(it)
            }
    }
}