package com.jemi.securebid.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.jemi.securebid.data.model.UserModel
import com.jemi.securebid.data.repository.AuthRepository
import com.jemi.securebid.data.repository.UserRepository

class AuthViewModel : ViewModel() {

    private val authRepository = AuthRepository()
    private val userRepository = UserRepository()

    var loading = mutableStateOf(false)
    var errorMessage = mutableStateOf<String?>(null)

    fun register(
        name: String,
        email: String,
        password: String,
        role: String,
        onSuccess: () -> Unit
    ) {
        loading.value = true

        authRepository.register(email, password) { success, error ->
            if (success) {
                val firebaseUser = authRepository.getCurrentUser()

                if (firebaseUser != null) {
                    val user = UserModel(
                        uid = firebaseUser.uid,
                        name = name,
                        email = email,
                        role = role
                    )

                    userRepository.saveUser(
                        user = user,
                        onSuccess = {
                            loading.value = false
                            onSuccess()
                        },
                        onFailure = {
                            loading.value = false
                            errorMessage.value = it.message
                        }
                    )
                }
            } else {
                loading.value = false
                errorMessage.value = error
            }
        }
    }

    fun login(
        email: String,
        password: String,
        onSuccess: () -> Unit
    ) {
        loading.value = true

        authRepository.login(email, password) { success, error ->
            loading.value = false

            if (success) {
                onSuccess()
            } else {
                errorMessage.value = error
            }
        }
    }

    fun isLoggedIn(): Boolean {
        return authRepository.getCurrentUser() != null
    }

    fun logout() {
        authRepository.logout()
    }
}