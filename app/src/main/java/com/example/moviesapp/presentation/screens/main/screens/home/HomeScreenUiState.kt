package com.example.moviesapp.presentation.screens.main.screens.home

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.example.moviesapp.presentation.models.movie.list.MovieResultUIModel
import kotlinx.collections.immutable.ImmutableList

@Immutable
sealed class HomeScreenUiState {

    @Stable
    data class Loaded(
        val popularMovies: ImmutableList<MovieResultUIModel>,
        val nowPlayingMovies: ImmutableList<MovieResultUIModel>,
        val topRatedMovies: ImmutableList<MovieResultUIModel>,
        val upcomingMovies: ImmutableList<MovieResultUIModel>,
    ) : HomeScreenUiState()

    data object Loading : HomeScreenUiState()

    @Immutable
    data class Error(
        val message: String,
    ) : HomeScreenUiState()
}