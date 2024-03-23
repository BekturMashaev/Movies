package com.example.moviesapp.presentation.components.screen.components.details

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.em
import com.example.moviesapp.presentation.theme.dp32

@Composable
fun ExpandableText(
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    text: String,
    collapsedMaxLine: Int = 4,
    fontSize: TextUnit
) {
    var isExpanded by remember { mutableStateOf(false) }
    val clickable by remember { mutableStateOf(false) }
    val lastCharIndex by remember { mutableIntStateOf(0) }

    Column() {
        Text(
            modifier = textModifier
                .fillMaxWidth()
                .animateContentSize(),
            text = buildAnnotatedString {
                if (clickable) {
                    if (isExpanded) {
                        append(text)
                    } else {
                        val adjustText = text.substring(startIndex = 0, endIndex = lastCharIndex)
                            .dropLastWhile { Character.isWhitespace(it) || it == '.' }
                        append(adjustText)
                    }
                } else {
                    append(text)
                }
            },
            maxLines = if (isExpanded) Int.MAX_VALUE else collapsedMaxLine,
            fontSize = fontSize,
            lineHeight = 1.2.em,
            fontWeight = FontWeight.Medium,
            color = Color.White,
        )
    }
    IconButton(
        modifier = modifier.fillMaxWidth(),
        onClick = { isExpanded = !isExpanded }
    ) {
        Icon(
            imageVector = if (isExpanded) Icons.Default.KeyboardArrowUp
            else Icons.Default.KeyboardArrowDown,
            contentDescription = null,
            tint = Color.White,
            modifier = modifier.size(dp32)
        )
    }
}