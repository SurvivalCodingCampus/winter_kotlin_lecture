package org.example.day13

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

object WeatherCoroutine

// 정지(suspend) 함수
// 정지 함수 안에서는 다른 정지 함수도 호출 가능
suspend fun WeatherCoroutine.tomorrow(): String {
    println(Thread.currentThread())
    println(2)
    delay(2000) // 2초 대기, Tread blocking 없이 대기
    return "맑음"
}

fun main() = runBlocking {
    println(Thread.currentThread())
    println(1)

    // 적절한 스래드로 갈아탄다.(디스패쳐를 전황)
    withContext(Dispatchers.IO) {
        println(Thread.currentThread())
        val data = WeatherCoroutine.tomorrow()
        println("내일 날씨는 $data")
    }

    saveFile()

    println(Thread.currentThread())
    println(3)
}

suspend fun saveFile() = withContext(Dispatchers.IO) {
    // 여기서 쓴 코드는 IO용 스레드에서 쓴다.
    println(Thread.currentThread())
}