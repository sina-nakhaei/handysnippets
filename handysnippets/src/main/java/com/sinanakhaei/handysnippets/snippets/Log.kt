package com.sinanakhaei.handysnippets.snippets

import android.util.Log

fun Any.logMe(tag: String = this.tag) {
    d(tag, this.toString())
}

fun Any.v(message: () -> String) {
    if (Log.isLoggable(tag, Log.VERBOSE)) v(message())
}

fun Any.d(message: () -> String) {
    if (Log.isLoggable(tag, Log.DEBUG)) d(message())
}

fun Any.i(message: () -> String) {
    if (Log.isLoggable(tag, Log.INFO)) i(message())
}

fun Any.e(message: () -> String) {
    if (Log.isLoggable(tag, Log.ERROR)) e(message())
}

fun Any.wtf(message: () -> String) = w(message())

fun Any.v(message: String) = v(tag, message)

fun Any.d(message: String) = d(tag, message)

fun Any.i(message: String) = i(tag, message)

fun Any.w(message: String) = w(tag, message)

fun Any.e(message: String) = e(tag, message)

fun Any.wtf(message: String) = wtf(tag, message)

inline fun v(tag: String, message: String) = Log.v(tag, message)

inline fun d(tag: String, message: String) = Log.d(tag, message)

inline fun i(tag: String, message: String) = Log.i(tag, message)

inline fun w(tag: String, message: String) = Log.w(tag, message)

inline fun e(tag: String, message: String) = Log.e(tag, message)

inline fun wtf(tag: String, message: String) = Log.wtf(tag, message)

inline fun <T> logTiming(tag: String = "Timing", message: String, block: () -> T): T {
    val startTime = System.currentTimeMillis()
    val result = block()
    val endTime = System.currentTimeMillis()
    d(tag, "$message: ${endTime - startTime} ms")
    return result
}

private val Any.tag: String
    get() = javaClass.simpleName
