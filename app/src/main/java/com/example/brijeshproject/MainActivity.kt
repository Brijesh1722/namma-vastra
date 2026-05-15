package com.example.brijeshproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.brijeshproject.ui.AppNavigation
import com.example.brijeshproject.ui.Screen
import com.example.brijeshproject.ui.theme.BrijeshProjectTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BrijeshProjectTheme {
                val navController = rememberNavController()
                val items = listOf(
                    Screen.Home to R.string.home,
                    Screen.Marketplace to R.string.marketplace,
                    Screen.Trends to R.string.trends,
                )
                
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        NavigationBar {
                            val navBackStackEntry by navController.currentBackStackEntryAsState()
                            val currentRoute = navBackStackEntry?.destination?.route
                            items.forEach { (screen, labelId) ->
                                NavigationBarItem(
                                    icon = {
                                        when(screen) {
                                            Screen.Home -> Icon(Icons.Filled.Home, contentDescription = null)
                                            Screen.Marketplace -> Icon(Icons.Filled.ShoppingCart, contentDescription = null)
                                            Screen.Trends -> Icon(Icons.Filled.Star, contentDescription = null)
                                            else -> {}
                                        }
                                    },
                                    label = { Text(stringResource(labelId)) },
                                    selected = currentRoute == screen.route,
                                    onClick = {
                                        navController.navigate(screen.route) {
                                            popUpTo(navController.graph.startDestinationId) {
                                                saveState = true
                                            }
                                            launchSingleTop = true
                                            restoreState = true
                                        }
                                    },
                                )
                            }
                        }
                    },
                ) { innerPadding ->
                    Surface(modifier = Modifier.padding(innerPadding)) {
                        AppNavigation(navController)
                    }
                }
            }
        }
    }
}
