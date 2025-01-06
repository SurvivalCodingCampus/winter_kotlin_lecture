package org.example.day13

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

// 싱글턴. 인스턴스 1개만 생성
object WeatherCoroutine

suspend fun WeatherCoroutine.tomorrow(): String {
    println("2")
    delay(2000)
    return "맑음"
}

fun main() = runBlocking {
    println("1")
    val data = WeatherCoroutine.tomorrow()
    println("내일 날씨는 $data")
    println("3")
}