package com.example.moviesapp.presentation.screens.main

import android.util.Log
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviesapp.presentation.components.screen.components.main.bottomNavigationList
import com.example.moviesapp.presentation.screens.main.screens.details.DetailsScreen
import com.example.moviesapp.presentation.screens.main.screens.details.DetailsScreenDestination
import com.example.moviesapp.presentation.screens.main.screens.details.DetailsScreenViewModel
import com.example.moviesapp.presentation.screens.main.screens.home.HomeScreen
import com.example.moviesapp.presentation.screens.main.screens.home.HomeScreenDestination
import com.example.moviesapp.presentation.screens.main.screens.home.HomeScreenViewModel
import com.example.moviesapp.presentation.screens.main.screens.library.LibraryScreen
import com.example.moviesapp.presentation.screens.main.screens.library.LibraryScreenDestination
import com.example.moviesapp.presentation.screens.main.screens.library.LibraryScreenViewModel
import com.example.moviesapp.presentation.screens.main.screens.search.SearchScreen
import com.example.moviesapp.presentation.screens.main.screens.search.SearchScreenDestination
import com.example.moviesapp.presentation.screens.main.screens.search.SearchScreenViewModel
import com.example.moviesapp.presentation.screens.main.screens.settings.SettingsScreensDestination
import com.example.moviesapp.presentation.theme.BottomBarBackgroundColor
import com.example.moviesapp.presentation.theme.dp0
import com.example.moviesapp.presentation.theme.dp70
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun MainScreen(
    onBackPressedCallback: () -> Unit,
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    var selectedItemIndex by remember {
        mutableIntStateOf(0)
    }
    val systemUiController = rememberSystemUiController()
    val homeScreenViewModel: HomeScreenViewModel = hiltViewModel()
    navController.addOnDestinationChangedListener { controller, destination, _ ->
        selectedItemIndex = when (destination.route) {
            HomeScreenDestination.route -> 0
            SearchScreenDestination.route -> 1
            LibraryScreenDestination.route -> 2
            SettingsScreensDestination.route -> 3
            else -> -1
        }
    }
    Scaffold(
        modifier = modifier.navigationBarsPadding(),
        contentWindowInsets = WindowInsets(top = dp0),
        bottomBar = {
            BottomAppBar(
                containerColor = BottomBarBackgroundColor,
                modifier = modifier.height(dp70),
            ) {
                bottomNavigationList().forEachIndexed { index, bottomNavigationItemModel ->
                    NavigationBarItem(
                        selected = selectedItemIndex == index,
                        onClick = {
                            if (selectedItemIndex != index) {
                                selectedItemIndex = index
                                navController.navigate(bottomNavigationItemModel.title)
                            }
                        },
                        icon = {
                            Icon(
                                painter = painterResource(id = bottomNavigationItemModel.icon),
                                contentDescription = null,
                                tint = if (index != selectedItemIndex) Color.White
                                else BottomBarBackgroundColor
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(indicatorColor = Color.White)
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = HomeScreenDestination.route,
            modifier = modifier.padding(innerPadding)
        ) {
            composable(HomeScreenDestination.route) {
                HomeScreen(
                    uiStateFlowMovie = homeScreenViewModel.uiState.collectAsState().value,
                    onBackPressedCallback = onBackPressedCallback,
                    onNavigateToInfo = { movieId ->
                        navController.navigate("${DetailsScreenDestination.route}/$movieId")
                    },
                    tryAgainCallBack = homeScreenViewModel::getAllMovies
                )
            }
            composable(SearchScreenDestination.route) {
                val searchScreenViewModel: SearchScreenViewModel = hiltViewModel()
                val query by searchScreenViewModel.searchText.collectAsState()
                val uiStateFlowMovie = searchScreenViewModel.uiState.collectAsState().value
                SearchScreen(
                    uiStateFlowMovie = uiStateFlowMovie,
                    onGetSearchedMovies = searchScreenViewModel::getSearchedMovies,
                    query = query,
                    onNavigateToInfo = { movieId ->
                        navController.navigate("${DetailsScreenDestination.route}/$movieId")
                    },
                    tryAgainCallBack = searchScreenViewModel::tryAgainCallBack
                )
            }
            composable(LibraryScreenDestination.route) {
                val libraryScreenViewModel: LibraryScreenViewModel = hiltViewModel()
                val uiStateFlowMovie = libraryScreenViewModel.uiState.collectAsState().value
                LibraryScreen(
                    uiState = uiStateFlowMovie,
                    onNavigateToInfo = { movieId ->
                        navController.navigate("${DetailsScreenDestination.route}/$movieId")
                    },
                )
            }
            composable(SettingsScreensDestination.route) {
            }
            composable(
                route = DetailsScreenDestination.routeWithArgs,
                arguments = DetailsScreenDestination.arguments
            ) { navBackStackEntry ->
                val detailsScreenViewModel: DetailsScreenViewModel = hiltViewModel()
                val movieId =
                    navBackStackEntry.arguments?.getInt(DetailsScreenDestination.movieId) ?: 0
                DetailsScreen(
                    onGetMovieInfo = { detailsScreenViewModel.getMovieInfo(movieId = movieId) },
                    uiStateFlowMovie = detailsScreenViewModel.uiState.collectAsState().value,
                    onBackPressedCallback = { navController.popBackStack() },
                    onSaveButtonCallBack = {model->
                        Log.d("AAA","loadedInMain ")
                        Log.d("AAA","loadedInMain $model")
//                        detailsScreenViewModel.saveMovie(model)
                    }
                )
            }
        }
    }
    SideEffect {
        systemUiController.setNavigationBarColor(BottomBarBackgroundColor)
    }
}