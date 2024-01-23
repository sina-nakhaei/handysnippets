package com.sinanakhaei.handysnippets.snippets.compose

import androidx.annotation.IntRange
import androidx.compose.ui.graphics.Color

fun Color.setOpacity(@IntRange(0, 100) percentage: Int): Color {
    val newAlpha = percentage.toFloat() / 100;
    return this.copy(alpha = newAlpha)
}