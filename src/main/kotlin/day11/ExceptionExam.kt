package org.example.day11

fun main() {
    println(stringToInt("10.5"))
}

fun stringToInt(numString: String): Int {
    var num: Int

    try {
        num = numString.toInt()
        println(num)
    } catch (e: Exception) {
        num = 0
        println(num)
    }

    return num
}