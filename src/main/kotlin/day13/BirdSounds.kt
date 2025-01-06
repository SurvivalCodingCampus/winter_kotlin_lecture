package org.hyunjung.day13

import kotlinx.coroutines.*

fun main() = runBlocking {
    val bird1 = launch {
        repeat(4) {
            println("꾸우")
            delay(1000)
        }
    }

    val bird2 = launch {
        repeat(4) {
            println("까악")
            delay(2000)
        }
    }

    val bird3 = launch {
        repeat(4) {
            println("짹짹")
            delay(3000)
        }
    }

    joinAll(bird1, bird2, bird3)
    println("모든 새가 4번씩 소리를 냈습니다!🕊️")
}