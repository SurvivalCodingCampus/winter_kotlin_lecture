package day13

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() = runBlocking {
    println(Thread.currentThread())
    println(1)
    withContext(Dispatchers.IO) {
        val data = Weather.tomorrow()
        println("내일 날씨는 $data")
        println(2)
    }
    println(3)
}

suspend fun Weather.tomorrow(): String {
    delay(2000)
    return "맑음"
}

object Weather