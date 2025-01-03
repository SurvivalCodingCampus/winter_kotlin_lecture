package day13

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


// 콜백 활용
object WeatherCoroutine

// 정지(suspend) 함수 (정지함수 안에서 다른 정지함수를 호출할 수도 있음. 쓰레드를 만들어가면서가 아니라 쓰레드를 서로에게 양보하면서 일한다. 쓰레드 하나로 일하는 경량쓰레드.)
suspend fun WeatherCoroutine.tommorow(): String {
    println(Thread.currentThread())
    println("2")
    delay(2000) // sleep처럼 똑같이 쉬는건데 스레드가 블록되지 않음.
    return "맑음"
}

fun main() = runBlocking {
    println(Thread.currentThread())
    println("1")
    val data = WeatherCoroutine.tommorow()
    println("내일 날씨는 $data")
    println("3")
    saveFile()
}

suspend fun saveFile() = withContext(Dispatchers.IO) {
    // 여기다 쓴 코드는 IO용 스레드에서 돈다
    println(Thread.currentThread())
}