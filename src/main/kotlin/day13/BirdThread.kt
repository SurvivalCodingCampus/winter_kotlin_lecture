package org.example.day13

import kotlinx.coroutines.*

fun main() = runBlocking {

    var job1 = launch {
        while (true) {
            bird1()
        }
    }

    val job2 = launch {
        while (true) {
            bird2()
        }
    }

    val job3 = launch {
        while (true) {
            bird3()
        }
    }

    delay(10000)
    job1.cancel()
    job2.cancel()
    job3.cancel()
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

// 1번 결과
// 꾸우
// 까악
// 짹짹
// 꾸우
// 까악
// 꾸우
// 짹짹
// 꾸우
// 까악
// 까악
// 짹짹
// 짹짹

// 2번 결과
// 꾸우
// 까악
// 짹짹
// 꾸우
// 까악
// 꾸우
// 짹짹
// 꾸우
// 까악
// 꾸우
// 꾸우
// 짹짹
// 까악
// 꾸우
// 꾸우
// 까악
// 꾸우
// 짹짹
// 꾸우