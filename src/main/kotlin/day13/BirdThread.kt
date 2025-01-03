package org.example.day13

import kotlinx.coroutines.*

fun main() = runBlocking {

    var job1: Job = launch {
        repeat(4) {
            bird1()
        }
    }

    val job2: Job = launch {
        repeat(4) {
            bird2()
        }
    }

    val job3: Job = launch {
        repeat(4) {
            bird3()
        }
    }
}

suspend fun bird1() {
    println("꾸우")
    delay(1000)
}

suspend fun bird2() {
    println("까악")
    delay(2000)
}

suspend fun bird3() {
    println("짹짹")
    delay(3000)
}