package com.sinanakhaei.handysnippets.snippets

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController


@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun hideKeyboard() {
    val keyboardController = LocalSoftwareKeyboardController.current
    keyboardController?.hide()
}