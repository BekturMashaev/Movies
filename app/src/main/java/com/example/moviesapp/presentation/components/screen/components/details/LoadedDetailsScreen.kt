package com.example.moviesapp.presentation.components.screen.components.details

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import com.example.moviesapp.R
import com.example.moviesapp.presentation.models.movie.info.MovieInfoDataModelUI
import com.example.moviesapp.presentation.theme.BlackBackgroundColor
import com.example.moviesapp.presentation.theme.RedButton
import com.example.moviesapp.presentation.theme.dp10
import com.example.moviesapp.presentation.theme.dp15
import com.example.moviesapp.presentation.theme.dp20
import com.example.moviesapp.presentation.theme.dp200
import com.example.moviesapp.presentation.theme.dp28
import com.example.moviesapp.presentation.theme.dp30
import com.example.moviesapp.presentation.theme.dp5
import com.example.moviesapp.presentation.theme.dp50
import com.example.moviesapp.presentation.theme.sp10
import com.example.moviesapp.presentation.theme.sp11
import com.example.moviesapp.presentation.theme.sp12
import com.example.moviesapp.presentation.theme.sp13
import com.example.moviesapp.presentation.theme.sp14
import com.example.moviesapp.presentation.theme.sp15
import com.example.moviesapp.presentation.theme.sp24

@Composable
fun LoadedDetailsScreen(
    modelUI: MovieInfoDataModelUI,
    onBackPressedCallback: () -> Unit,
    onSaveButtonCallBack: (MovieInfoDataModelUI) -> Unit,
    modifier: Modifier = Modifier,
) {
    val scrollState = rememberScrollState()
    Box(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .background(BlackBackgroundColor),
        ) {
            Box(
                modifier = modifier.fillMaxSize()
            ) {
                BackgroundPosterPath(poster = modelUI.posterPath.orEmpty())
                Column(
                    modifier = modifier.padding(horizontal = dp15)
                ) {
                    Spacer(modifier = modifier.height(380.dp))
                    Text(
                        text = modelUI.title.orEmpty(),
                        color = Color.White,
                        fontWeight = FontWeight.Medium,
                        fontSize = sp24,
                        textAlign = TextAlign.Start,
                        maxLines = 2,
                        lineHeight = 1.2.em,
                        overflow = TextOverflow.Ellipsis
                    )
                    Row(
                        modifier = modifier.padding(top = dp10),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Card(
                            colors = CardDefaults.cardColors(Color.Transparent),
                            shape = RoundedCornerShape(dp5),
                            modifier = modifier.width(dp30)
                        ) {
                            Text(
                                text = if (modelUI.adult == true) {
                                    "12+"
                                } else {
                                    "7+"
                                },
                                color = Color.Black,
                                textAlign = TextAlign.Center,
                                fontSize = sp12,
                                modifier = modifier
                                    .fillMaxSize()
                                    .background(color = Color.White.copy(alpha = 0.7f))
                            )
                        }
                        Icon(
                            painter = painterResource(id = R.drawable.dot),
                            contentDescription = null,
                            tint = Color.White
                        )
                        Text(
                            text = modelUI.releaseDate.orEmpty(),
                            color = Color.White,
                            fontSize = sp10,
                        )
                        Icon(
                            painter = painterResource(id = R.drawable.dot),
                            contentDescription = null,
                            tint = Color.White
                        )
                        Text(
                            text = minutesToHours(modelUI.runtime ?: 0),
                            color = Color.White,
                            fontSize = sp10,
                        )
                    }
                    val countryName =
                        modelUI.country?.firstOrNull()?.uppercase() ?: "Unknown Country"
                    val genresText = modelUI.genres?.joinToString { it }
                    val genres = genresText ?: "Unknown Genres"
                    Spacer(modifier = modifier.height(dp5))
                    Text(
                        text = "$countryName • $genres",
                        fontSize = sp10,
                        color = Color.White
                    )
                    Row(
                        modifier = modifier
                            .fillMaxWidth(0.95f)
                            .padding(top = dp15),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Button(
                            onClick = {
                                Log.d("AAA","button")
                                onSaveButtonCallBack(modelUI)
                                      },
                            shape = RoundedCornerShape(dp30),
                            colors = ButtonDefaults.buttonColors(
                                RedButton
                            ),
                            modifier = modifier
                                .height(dp50)
                                .width(dp200),
                        ) {
                            Text(
                                text = stringResource(R.string.nothing),
                                fontWeight = FontWeight.Medium,
                                fontSize = sp15,
                                color = Color.White,
                            )
                        }
                        Spacer(modifier = modifier.weight(1f))
                        IconButton(
                            onClick = { onSaveButtonCallBack(modelUI) },
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.FavoriteBorder,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = modifier
                                    .size(dp28)
                                    .align(Alignment.CenterVertically)
                            )
                        }
                        Spacer(modifier = modifier.weight(1f))
                        IconButton(
                            onClick = { /*TODO*/ },
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.MoreVert,
                                contentDescription = null,
                                tint = Color.White,
                                modifier = modifier
                                    .size(dp28)
                                    .align(Alignment.CenterVertically)
                            )
                        }
                    }
                }
            }
            Column(
                modifier = modifier
                    .padding(horizontal = dp15)
                    .padding(top = dp20)
            ) {
                Text(
                    text = "${modelUI.voteAverage ?: 0.0}",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontWeight = FontWeight.Medium,
                    fontSize = sp14,
                    modifier = modifier.fillMaxWidth()
                )
                Text(
                    text = "IMBD",
                    textAlign = TextAlign.Center,
                    color = Color.White,
                    fontSize = sp11,
                    modifier = modifier.fillMaxWidth()
                )
                Spacer(modifier = modifier.height(dp20))
                ExpandableText(
                    text = modelUI.overview.orEmpty(),
                    fontSize = sp13,
                )
            }
        }
    }
    FloatingBackButton(
        onBackPressedCallback = onBackPressedCallback
    )
}


@Composable
fun minutesToHours(minutes: Int): String {
    return if (minutes > 60) {
        val hours = minutes / 60
        val remainingMinutes = minutes % 60
        "${hours}h ${remainingMinutes}min"
    } else {
        "${minutes}h"
    }
}