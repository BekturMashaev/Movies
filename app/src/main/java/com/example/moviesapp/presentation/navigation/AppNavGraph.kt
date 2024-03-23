package com.example.moviesapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviesapp.presentation.screens.main.MainDestination
import com.example.moviesapp.presentation.screens.main.MainScreen
import com.example.moviesapp.presentation.screens.splash.SplashDestination
import com.example.moviesapp.presentation.screens.splash.SplashScreen

@Composable
fun AppNavGraph(
    onBackPressedCallback: () -> Unit,
) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = SplashDestination.route,
    ) {
        composable(
            MainDestination.route
        ) {
            MainScreen(
                onBackPressedCallback = onBackPressedCallback
            )
        }
        composable(SplashDestination.route) {
            SplashScreen(
                onNavigation = { navController.navigate(MainDestination.route) }
            )
        }
    }
}