package com.example.moviesapp.presentation.screens.main.screens.details

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import com.example.moviesapp.presentation.models.movie.info.MovieInfoDataModelUI

@Immutable
sealed class DetailsScreenUIState {
    @Stable
    data class Loaded(
        val movie: MovieInfoDataModelUI
    ) : DetailsScreenUIState()

    data object Loading : DetailsScreenUIState()

    @Immutable
    data class Error(
        val message: String,
    ) : DetailsScreenUIState()
}