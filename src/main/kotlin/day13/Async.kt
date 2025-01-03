package org.example.day13

import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    // 현재 사용 중인 Thread를 출력
    // runBlocking 과는 상관 없음
    println(Thread.currentThread())
    println("쿵")
    // 1초 대기
    Thread.sleep(1000)
    println("쾅")

    Thread {
        Thread.sleep(500)
        // Thread-0
        println(Thread.currentThread())
        println("쿵")
    }.start()

    Thread {
        // Thread-1
        println(Thread.currentThread())
        println("쾅")
    }.start()
}