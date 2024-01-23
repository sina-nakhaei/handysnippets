package com.sinanakhaei.handysnippets.snippets

import androidx.compose.ui.Modifier

fun Modifier.setIf(
    condition: Boolean,
    modifier: (modifier: Modifier) -> Modifier
): Modifier {
    return if (condition)
        modifier(this)
    else this
}