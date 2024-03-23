package com.example.moviesapp.presentation.screens.main.screens.library

import androidx.compose.runtime.Immutable
import com.example.moviesapp.presentation.models.movie.info.MovieInfoDataModelUI
import kotlinx.collections.immutable.ImmutableList

@Immutable
sealed class LibraryScreenUiState {

//    data object isFirstTyping:LibraryScreenUiState()

    @Immutable
    data class Loaded(
        val movies: ImmutableList<MovieInfoDataModelUI>,
    ) : LibraryScreenUiState()

    data object Loading : LibraryScreenUiState()

    @Immutable
    data class Error(
        val message: String,
    ) : LibraryScreenUiState()
}