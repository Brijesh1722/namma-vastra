package com.example.brijeshproject.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.brijeshproject.ui.screens.CustomOrderScreen
import com.example.brijeshproject.ui.screens.HomeScreen
import com.example.brijeshproject.ui.screens.MarketplaceScreen
import com.example.brijeshproject.ui.screens.TrendsScreen

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Marketplace.route) { MarketplaceScreen(navController) }
        composable(Screen.Trends.route) { TrendsScreen(navController) }
        composable(
            route = Screen.CustomOrder.route + "?weaverId={weaverId}",
            arguments = listOf(
                navArgument("weaverId") {
                    type = NavType.StringType
                    nullable = true
                    defaultValue = null
                },
            ),
        ) { backStackEntry ->
            val weaverId = backStackEntry.arguments?.getString("weaverId")
            CustomOrderScreen(navController, weaverId)
        }
    }
}

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Marketplace : Screen("marketplace")
    object Trends : Screen("trends")
    object CustomOrder : Screen("custom_order")
}
