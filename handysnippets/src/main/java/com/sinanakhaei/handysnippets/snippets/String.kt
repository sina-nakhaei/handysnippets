package com.sinanakhaei.handysnippets.snippets

inline fun String?.or(value: String): String = this ?: value

inline fun String.isEmail(): Boolean {
    val emailRegex = Regex("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}")
    return emailRegex.matches(this)
}

fun String.truncate(maxLength: Int): String {
    if (length <= maxLength) {
        return this
    }
    return substring(0, maxLength).trimEnd() + "..."
}
