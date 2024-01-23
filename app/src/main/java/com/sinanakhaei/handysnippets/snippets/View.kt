package com.sinanakhaei.handysnippets.snippets

import android.view.View

fun View.hide(gone: Boolean = true) {
    visibility = if (gone) View.GONE
    else View.INVISIBLE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.visible() = (this.visibility == View.VISIBLE)

private const val DEFAULT_DEBOUNCE_TIME_MS = 300L

fun View.setOnSafeClickListener(
    debounceTimeMs: Long = DEFAULT_DEBOUNCE_TIME_MS,
    onClick: (View) -> Unit
) {
    var lastClickTime = 0L
    setOnClickListener { view ->
        val currentTime = System.currentTimeMillis()
        if (currentTime - lastClickTime >= debounceTimeMs) {
            lastClickTime = currentTime
            onClick(view)
        }
    }
}