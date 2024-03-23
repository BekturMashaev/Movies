package com.example.moviesapp.presentation.screens.main.screens.home

import android.annotation.SuppressLint
import androidx.activity.addCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.moviesapp.R
import com.example.moviesapp.presentation.components.common.error.ErrorScreen
import com.example.moviesapp.presentation.components.common.loading.LoadingScreen
import com.example.moviesapp.presentation.components.screen.components.home.MoviesCategoryTitle
import com.example.moviesapp.presentation.components.screen.components.home.MoviesListLazyRow
import com.example.moviesapp.presentation.components.screen.components.home.PopularMoviesPager
import com.example.moviesapp.presentation.theme.BlackBackgroundColor

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    onBackPressedCallback: () -> Unit,
    onNavigateToInfo: (Int) -> Unit,
    uiStateFlowMovie: HomeScreenUiState,
    tryAgainCallBack: () -> Unit,
    modifier: Modifier = Modifier,
) {
    when (uiStateFlowMovie) {
        is HomeScreenUiState.Loading -> LoadingScreen()
        is HomeScreenUiState.Loaded -> {
            val backStackDispatcher = LocalOnBackPressedDispatcherOwner.current
            backStackDispatcher?.onBackPressedDispatcher?.addCallback {
                onBackPressedCallback()
            }
            Column(
                modifier = modifier
                    .verticalScroll(rememberScrollState())
                    .background(BlackBackgroundColor)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                PopularMoviesPager(
                    list = uiStateFlowMovie.popularMovies,
                    onNavigateToInfo=onNavigateToInfo
                )
                MoviesCategoryTitle(text = stringResource(R.string.top_rated_movies))
                MoviesListLazyRow(
                    moviesList = uiStateFlowMovie.topRatedMovies,
                    onNavigateToInfo = onNavigateToInfo
                )
                MoviesCategoryTitle(text = stringResource(R.string.upcoming_movies))
                MoviesListLazyRow(
                    moviesList = uiStateFlowMovie.upcomingMovies,
                    onNavigateToInfo = onNavigateToInfo
                )
                MoviesCategoryTitle(text = stringResource(R.string.now_playing_movies))
                MoviesListLazyRow(
                    moviesList = uiStateFlowMovie.nowPlayingMovies,
                    onNavigateToInfo = onNavigateToInfo
                )
            }
        }

        is HomeScreenUiState.Error -> ErrorScreen(message = uiStateFlowMovie.message) {
            tryAgainCallBack()
        }
    }
}
