package org.example.day13

// JAVA 스타일 (Thread 활용)

// singleton object
object Weather

fun Weather.tomorrow(): String {
    Thread.sleep(2000)
    return "맑음"
}

fun main() {
    val data = Weather.tomorrow()
    println("내일 날씨는 $data")
}