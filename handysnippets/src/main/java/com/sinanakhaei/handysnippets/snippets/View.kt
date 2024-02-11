package com.sinanakhaei.handysnippets.snippets

import android.view.View
import android.view.ViewGroup
import androidx.core.view.marginBottom
import androidx.core.view.marginEnd
import androidx.core.view.marginLeft
import androidx.core.view.marginRight
import androidx.core.view.marginStart
import androidx.core.view.marginTop

fun View.hide() {
    visibility = View.GONE
}

fun View.invisible() {
    visibility = View.INVISIBLE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun View.isVisible() = (this.visibility == View.VISIBLE)

fun View.toggleVisibility(gone: Boolean = true) {
    visibility = if (visibility == View.VISIBLE) {
        if (gone) View.GONE
        else View.INVISIBLE
    } else View.VISIBLE
}

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

fun View.fadeIn(duration: Long = 300) {
    alpha = 0f
    visibility = View.VISIBLE
    animate()
        .alpha(1f)
        .setDuration(duration)
        .start()
}

fun View.fadeOut(duration: Long = 300) {
    animate().alpha(0f)
        .setDuration(duration)
        .withEndAction { visibility = View.GONE }
        .start()
}

fun View.disable() {
    isEnabled = false
    isClickable = false
}

fun View.enable() {
    isEnabled = true
    isClickable = true
}

fun View.setMargins(
    start: Int = marginStart,
    top: Int = marginTop,
    end: Int = marginEnd,
    bottom: Int = marginBottom
) {
    val params = layoutParams as ViewGroup.MarginLayoutParams
    params.setMargins(start, top, end, bottom)
    layoutParams = params
}