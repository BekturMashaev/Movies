package com.example.moviesapp.presentation.components.screen.components.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.moviesapp.R
import com.example.moviesapp.presentation.theme.BlackBackgroundColor

@Composable
fun BackgroundPosterPath(
    poster: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.heightIn(min = 300.dp, max = 530.dp)
    ) {
        Image(
            painter = rememberAsyncImagePainter(
                ImageRequest.Builder(LocalContext.current)
                    .data(data = poster).apply(
                        block = fun ImageRequest.Builder.() {
                            placeholder(R.drawable.place_holder)
                        },
                    ).build()
            ),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            BlackBackgroundColor,
                            Color.Transparent,
                            BlackBackgroundColor,
                        )
                    )
                ),
        )
    }
}