package com.sinanakhaei.handysnippets.snippets

fun Number.isMoreThan(value: Number): Boolean = (toDouble() > value.toDouble())
fun Number.equalsOrMoreThan(value: Number): Boolean = (toDouble() >= value.toDouble())

fun Number.isLessThan(value: Number): Boolean = (toDouble() < value.toDouble())
fun Number.equalsOrLessThan(value: Number): Boolean = (toDouble() <= value.toDouble())

fun Number.isEven(): Boolean = (toDouble() % 2.0 == 0.0)
fun Number.isOdd(): Boolean = !isEven()

fun Number.isPositive() = toDouble() > 0.0
fun Number.isNegative() = toDouble() < 0.0
