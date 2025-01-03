package org.example.day11

fun main() {
    val numString = "10.5"

    val num = try {
        numString.toInt()
    } catch (e: NumberFormatException) {
        println("올바른 숫자 형식이 아닙니다.")
        0
    }

    println(num)
}