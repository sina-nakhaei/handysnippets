package com.sinanakhaei.handysnippets.snippets

import android.view.View

fun View.hide(gone: Boolean = true) {
    visibility = if (gone) View.GONE
    else View.INVISIBLE
}

fun View.show() {
    visibility = View.VISIBLE
}