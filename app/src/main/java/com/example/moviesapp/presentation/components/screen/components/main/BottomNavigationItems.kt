package com.example.moviesapp.presentation.components.screen.components.main

import com.example.moviesapp.R
import com.example.moviesapp.presentation.screens.main.screens.home.HomeScreenDestination
import com.example.moviesapp.presentation.screens.main.screens.library.LibraryScreenDestination
import com.example.moviesapp.presentation.screens.main.screens.search.SearchScreenDestination
import com.example.moviesapp.presentation.screens.main.screens.settings.SettingsScreensDestination


data class BottomNavigationItemModel(
    val title: String,
    val icon: Int
)

fun bottomNavigationList() = listOf(
    BottomNavigationItemModel(
        HomeScreenDestination.route,
        R.drawable.home_icon,
    ),
    BottomNavigationItemModel(
        SearchScreenDestination.route,
        R.drawable.search_icon,
    ),
    BottomNavigationItemModel(
        LibraryScreenDestination.route,
        R.drawable.library_icon,
    ),
    BottomNavigationItemModel(
        SettingsScreensDestination.route,
        R.drawable.settings_icon,
    )
)