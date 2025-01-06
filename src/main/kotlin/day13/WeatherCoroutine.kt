package org.example.day13

import kotlinx.coroutines.*

// 싱글턴
object WeatherCoroutine

// I/O 를 한다고 치자
// 정지(suspend) 함수
suspend fun WeatherCoroutine.tomorrow(): String {
    println(Thread.currentThread())
    println("2")
    delay(2000)
    return "맑음"
}

fun main() = runBlocking {
    println(Thread.currentThread())
    println("1")

    // 디스패처를 전환 (적절한 스레드로 갈아 탄다)
    withContext(Dispatchers.IO) {
        val data = WeatherCoroutine.tomorrow ()
        println("내일 날씨는 $data")
    }

    saveFile()

    println(Thread.currentThread())
    println("3")
}

suspend fun saveFile() = withContext(Dispatchers.IO) {
    // 여기다 쓴 코드 IO용 스레드에서 돈다
    println(Thread.currentThread())
}