package com.survivalcoding.com.survivalcoding.day13.exam

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    val jobs = launch {
        val job1 = launch {
            while (true) {
                delay(1000L)
                println("꾸우")
            }
        }
        val job2 = launch {
            while (true) {
                delay(2000L)
                println("까악")
            }
        }
        val job3 = launch {
            while (true) {
                delay(3000L)
                println("짹짹")
            }
        }
    }

    delay(10_000L)
    jobs.cancel()
}