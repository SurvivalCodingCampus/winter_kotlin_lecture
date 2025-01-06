package day13

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.system.measureTimeMillis

suspend fun task1(): Int {
    delay(1000)
    return 1
}

suspend fun task2(): Int {
    delay(1500)
    return 2
}

suspend fun task3(): Int {
    delay(2000)
    return 3
}

//fun main() = runBlocking {
//    val time = measureTimeMillis {
//        val result1 = task1()
//        val result2 = task2()
//        val result3 = task3()
//
//        val totalResult = result1 + result2 + result3
//        println("Total result: $totalResult")
//    }
//    println("Execution time: $time ms")
//}

fun main() = runBlocking {
    val time = measureTimeMillis {
        val result1 = async { task1() }
        val result2 = async { task2() }
        val result3 = async { task3() }

        val totalResult = result1.await() + result2.await() + result3.await()
        println("Total result: $totalResult")
    }
    println("Execution time: $time ms")
}