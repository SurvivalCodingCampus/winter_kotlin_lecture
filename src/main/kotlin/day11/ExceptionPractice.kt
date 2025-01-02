package org.example.day11

fun main() {
    val numString = "10.5"
    var num: Int = 0

    try {
        num = numString.toInt()
    } catch (e: NumberFormatException) {
        println("숫자가 정수형이 아닙니다")
    }

    println(num)
}