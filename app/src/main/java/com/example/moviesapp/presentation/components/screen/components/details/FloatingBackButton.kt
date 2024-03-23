package com.example.moviesapp.presentation.components.screen.components.details

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.moviesapp.presentation.theme.BlackBackgroundColor
import com.example.moviesapp.presentation.theme.dp10
import com.example.moviesapp.presentation.theme.dp28
import com.example.moviesapp.presentation.theme.dp40
import com.example.moviesapp.presentation.theme.dp46

@Composable
fun FloatingBackButton(
    onBackPressedCallback: () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.padding(top = dp40, start = dp10)) {
        FloatingActionButton(
            onClick = { onBackPressedCallback() },
            modifier = modifier
                .size(dp46)
                .align(Alignment.TopStart),
            containerColor = BlackBackgroundColor,
            shape = CircleShape
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBack,
                contentDescription = null,
                tint = Color.White,
                modifier = modifier.size(dp28)
            )
        }
    }
}