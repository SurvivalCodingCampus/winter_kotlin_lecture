package org.example.day13

import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

object WeatherCoroutine

suspend fun WeatherCoroutine.tomorrow(): String {
    delay(2000)
    return "맑음"
}

//@OptIn(DelicateCoroutinesApi::class)
fun main() {
    //val data = WeatherCoroutine.tomorrow()
    //println("내일 날씨는 $data")

    println(1)
    val job = GlobalScope.launch {
        delay(1000L)
        println(2)
    }
    println(3)

    measureTimeMillis {  }
}