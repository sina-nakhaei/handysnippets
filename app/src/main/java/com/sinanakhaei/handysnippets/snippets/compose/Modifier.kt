package com.sinanakhaei.handysnippets.snippets.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed

fun Modifier.setIf(
    condition: Boolean,
    modifier: (modifier: Modifier) -> Modifier
): Modifier {
    return if (condition)
        modifier(this)
    else this
}

private const val DEFAULT_DEBOUNCE_TIME_MS = 300L

@Composable
fun Modifier.onSafeClick(
    debounceTimeMs: Long = DEFAULT_DEBOUNCE_TIME_MS,
    onClick: () -> Unit
): Modifier {
    var lastClickTime by remember { mutableStateOf(0L) }

    return composed {
        clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null
        ) {
            val currentTime = System.currentTimeMillis()
            if (currentTime - lastClickTime >= debounceTimeMs) {
                lastClickTime = currentTime
                onClick()
            }
        }
    }
}