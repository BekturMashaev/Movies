package com.example.moviesapp.presentation.components.screen.components.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.moviesapp.presentation.models.movie.list.MovieResultUIModel
import com.example.moviesapp.presentation.theme.dp10
import com.example.moviesapp.presentation.theme.dp2
import kotlinx.collections.immutable.ImmutableList

@Composable
fun MoviesListLazyRow(
    onNavigateToInfo: (Int) -> Unit,
    moviesList: ImmutableList<MovieResultUIModel>,
    modifier: Modifier = Modifier,
) {
    LazyRow(
        modifier = modifier.padding(top = dp10),
        horizontalArrangement = Arrangement.spacedBy(dp10),
    ) {
        item { Spacer(modifier = modifier.width(dp2)) }
        items(
            items = moviesList,
            key = { model ->
                model.id
            }
        ) { model ->
            MovieItem(
                onNavigateToInfo = onNavigateToInfo,
                picture = model.poster.orEmpty(),
                language = model.language.orEmpty(),
                releaseDate = model.releaseDate.orEmpty(),
                title = model.title.orEmpty(),
                movieId = model.id
            )
        }
        item { Spacer(modifier = modifier.width(dp2)) }
    }
}