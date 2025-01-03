package day13

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
    val time = measureTimeMillis {
        val result1 = task1()
        val result2 = task2()
        val result3 = task3()

        val totalResult = result1 + result2 + result3

        println("Total result: $totalResult")
    }

    println("Execution time: $time ms")
}

suspend fun task1(): Int {
    delay(1000L)
    return 1
}

suspend fun task2(): Int {
    delay(1500L)
    return 2
}

suspend fun task3(): Int {
    delay(2000L)
    return 3
}