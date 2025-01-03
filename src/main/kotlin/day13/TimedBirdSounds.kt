package org.hyunjung.day13

import kotlinx.coroutines.*

fun main() = runBlocking {
    val parentJob = SupervisorJob()
    val scope = CoroutineScope(Dispatchers.Default + parentJob)

    scope.launch {
        while (isActive) {
            println("꾸우")
            delay(1000)
        }
    }

    scope.launch {
        while (isActive) {
            println("까악")
            delay(2000)
        }
    }

    scope.launch {
        while (isActive) {
            println("짹짹")
            delay(3000)
        }
    }

    delay(10000)
    println("10초 경과: 창문을 닫고 준비를 시작해요!🕊️")
    scope.cancel()
}