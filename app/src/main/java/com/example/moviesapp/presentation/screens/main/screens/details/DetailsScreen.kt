package com.example.moviesapp.presentation.screens.main.screens.details

import android.util.Log
import androidx.activity.addCallback
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.tooling.preview.Preview
import com.example.moviesapp.presentation.components.common.error.ErrorScreen
import com.example.moviesapp.presentation.components.common.loading.LoadingScreen
import com.example.moviesapp.presentation.components.screen.components.details.LoadedDetailsScreen
import com.example.moviesapp.presentation.models.movie.info.MovieInfoDataModelUI

@Composable
fun DetailsScreen(
    onGetMovieInfo: () -> Unit,
    onBackPressedCallback: () -> Unit,
    uiStateFlowMovie: DetailsScreenUIState,
    onSaveButtonCallBack: (MovieInfoDataModelUI) -> Unit,
) {
    val backStackDispatcher = LocalOnBackPressedDispatcherOwner.current
    backStackDispatcher?.onBackPressedDispatcher?.addCallback {
        onBackPressedCallback()
    }
    LaunchedEffect(
        key1 = true,
    ) {
        onGetMovieInfo()
    }
    when (uiStateFlowMovie) {
        is DetailsScreenUIState.Loading -> LoadingScreen()
        is DetailsScreenUIState.Loaded -> {
            LoadedDetailsScreen(
                uiStateFlowMovie.movie,
                onBackPressedCallback = onBackPressedCallback,
                onSaveButtonCallBack = {
                    Log.d("AAA","loadedDetails")
                    Log.d("AAA","loadedDetails $it")
                    onSaveButtonCallBack(it)
                }
            )
        }

        is DetailsScreenUIState.Error -> ErrorScreen(message = uiStateFlowMovie.message) {
            onGetMovieInfo()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DetailsScreenPreview() {
    MaterialTheme {
        DetailsScreen(
            onGetMovieInfo = {},
            uiStateFlowMovie = DetailsScreenUIState.Loaded(
                MovieInfoDataModelUI.unknown
            ),
            onBackPressedCallback = {},
            onSaveButtonCallBack = {}
        )
    }
}



