package org.example.day11

fun main() {
    val numString = "10.5"
    val num: Int = try {
        numString.toInt()
    } catch (e: Exception) {
        0
    }
    println(num)
}

private fun String.toInt(): Int {
    throw Exception("에러 발생")

    @Suppress("UNREACHABLE_CODE")
    return this.toInt()
}