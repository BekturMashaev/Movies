package com.example.moviesapp.presentation.screens.main.screens.library

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.moviesapp.presentation.components.screen.components.search.MovieSearchItem

@Composable
fun LibraryScreen(
    uiState: LibraryScreenUiState,
    onNavigateToInfo: (Int) -> Unit,
) {
    when (uiState) {
        is LibraryScreenUiState.Error -> TODO()
        is LibraryScreenUiState.Loaded -> LazyColumn {
            items(items = uiState.movies) { model ->
                MovieSearchItem(
                    picture = model.posterPath.orEmpty(),
                    releaseDate = model.releaseDate.orEmpty(),
                    language = model.originalLanguage.orEmpty(),
                    title = model.title.orEmpty(),
                    onNavigateToInfo = onNavigateToInfo,
                    movieId = model.id
                )
            }
        }

        is LibraryScreenUiState.Loading -> TODO()
    }
}