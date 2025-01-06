package day13

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

suspend fun task4(): Int {
    delay(1000) // 가정: task1은 1초 동안 실행됨
    return 1
}

suspend fun task5(): Int {
    delay(1500) // 가정: task2는 1.5초 동안 실행됨
    return 2
}

suspend fun task6(): Int {
    delay(2000) // 가정: task2는 2초 동안 실행됨
    return 3
}

// 병렬 시행
fun main() = runBlocking {
    val time = measureTimeMillis {
        val result1 = async { task4() }
        val result2 = async { task5() }
        val result3 = async { task6() }

        val totalResult = result1.await() + result2.await() + result3.await()

        println("Total result: $totalResult") // 6
    }
    println("Execution time: $time ms") // 2074 ms
}