package org.example.day11.exam

fun main() {
    val numString = "10.5"
    val num = numString.toIntOrNull() ?: 0

    println(num)
}

fun solution1() {
    var num = 0

    try {
        val numString = "10.5"
        num = numString.toInt()
    } catch (_: Exception) {

    }

    println(num)
}