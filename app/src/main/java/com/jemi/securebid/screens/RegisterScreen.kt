package com.jemi.securebid.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.jemi.securebid.viewmodel.AuthViewModel

@Composable
fun RegisterScreen(navController: NavController) {

    val viewModel = remember { AuthViewModel() }

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var selectedRole by remember { mutableStateOf("buyer") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Register SecureBid",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Password") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text("Pilih Role")

        Row {
            RadioButton(
                selected = selectedRole == "buyer",
                onClick = { selectedRole = "buyer" }
            )
            Text("Buyer")

            Spacer(modifier = Modifier.width(16.dp))

            RadioButton(
                selected = selectedRole == "seller",
                onClick = { selectedRole = "seller" }
            )
            Text("Seller")
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                viewModel.register(
                    name = name,
                    email = email,
                    password = password,
                    role = selectedRole
                ) {
                    navController.navigate("home")
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Register")
        }

        Spacer(modifier = Modifier.height(12.dp))

        TextButton(
            onClick = {
                navController.popBackStack()
            }
        ) {
            Text("Sudah punya akun? Login")
        }
    }
}