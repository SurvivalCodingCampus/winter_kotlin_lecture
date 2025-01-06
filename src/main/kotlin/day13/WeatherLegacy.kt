package org.example.day13

// Java 스타일 (Thread 활용)

object Weather
fun main() {
    val data = Weather.tomorrow()
    println("내일 날씨는: $data")
}

fun Weather.tomorrow(): String {
    Thread.sleep(2000)
    return "맑음"
}