package com.example.moviesapp.presentation.screens.main.screens.details

import androidx.navigation.NavType
import androidx.navigation.navArgument
import com.example.moviesapp.presentation.navigation.Destination

object DetailsScreenDestination : Destination {
    override val route = "details_screen"
    const val movieId = "movieId"
    val routeWithArgs = "$route/{$movieId}"
    val arguments = listOf(navArgument(movieId) { type = NavType.IntType })
}