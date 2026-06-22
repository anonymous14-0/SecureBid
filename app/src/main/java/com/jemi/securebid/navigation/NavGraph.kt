package com.jemi.securebid.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.jemi.securebid.screens.HomeScreen
import com.jemi.securebid.screens.LoginScreen
import com.jemi.securebid.screens.RegisterScreen
import com.jemi.securebid.screens.CreateAuctionScreen
import com.jemi.securebid.screens.AuctionListScreen

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(navController)
        }

        composable("register") {
            RegisterScreen(navController)
        }

        composable("home") {
            HomeScreen(navController)
        }

        composable("create_auction") {
            CreateAuctionScreen()
        }

        composable("auction_list") {
            AuctionListScreen()
        }
    }
}