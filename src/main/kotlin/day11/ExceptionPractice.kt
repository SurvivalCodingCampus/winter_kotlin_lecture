package org.example.day11

fun main() {
    val numString = "10.5"
    var num: Int = 0

    try {
        num = numString.toInt()
    } catch (e: NumberFormatException) {
        num = 0
    }

    println(num)
}