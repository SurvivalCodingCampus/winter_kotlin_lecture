package org.example.day13

import kotlinx.coroutines.*

fun main() = runBlocking {

    var job1: Job = launch {
        while (true) {
            bird1()
        }
    }

    val job2: Job = launch {
        while (true) {
            bird2()
        }
    }

    val job3: Job = launch {
        while (true) {
            bird3()
        }
    }

    val jobCancle: Job = launch {
        delay(10000)
        job1.cancel()
        job2.cancel()
        job3.cancel()
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