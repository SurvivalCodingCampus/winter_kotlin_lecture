package day13

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

object WeatherCoroutine

suspend fun WeatherCoroutine.tomorrow(): String {       // suspend : 정지 함수
    println(Thread.currentThread())                     // 현재 스레드 확인
    println("2")
    delay(2000) // 스레드가 블록되지 않음
    return "맑음"
}

fun main() = runBlocking {      // runBlocking : 코루틴 스코프
    println(Thread.currentThread())
    println("1")

    // 디스패처를 전환( 적절한 스레드로 갈아탄다)
    withContext(Dispatchers.IO) {
        val data = WeatherCoroutine.tomorrow()
        println("내일 날씨는 $data")
    }
    saveFile()
    println(Thread.currentThread())
    println("3")
}

suspend fun saveFile() = withContext(Dispatchers.IO) {
    // 여기다 쓴 코드는 IO용 스레드에서 돈다
    println(Thread.currentThread())
}