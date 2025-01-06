package day13

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

suspend fun task1(): Int {
    delay(1000) // 가정: task1은 1초 동안 실행됨
    return 1
}

suspend fun task2(): Int {
    delay(1500) // 가정: task2는 1.5초 동안 실행됨
    return 2
}

suspend fun task3(): Int {
    delay(2000) // 가정: task2는 2초 동안 실행됨
    return 3
}

// 순차 시행
fun main() = runBlocking {
    val time = measureTimeMillis {
        val result1 = task1()
        val result2 = task2()
        val result3 = task3()

        val totalResult = result1 + result2 + result3

        println("Total result: $totalResult") // 6
    }
    println("Execution time: $time ms") // 4571 ms
}