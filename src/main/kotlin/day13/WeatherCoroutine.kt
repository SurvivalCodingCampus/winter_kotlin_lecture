package day13

import kotlinx.coroutines.*

fun main() = runBlocking {
    println(1)
    val job: Job = launch {
        delay(1000L)
        println(2)
    }
    println(3)
}
