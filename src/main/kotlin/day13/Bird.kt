package org.example.day13

import kotlinx.coroutines.*

class Bird(
    private val sound: String,
    private val time: Long,
) {
    suspend fun tweet() {
        delay(time)
        println(sound)
    }
}

fun main() = runBlocking {
    val jobs = mutableListOf<Job>()
    val end = launch {
        delay(10_000L)
    }
    listOf(
        Bird("꾸우", 1_000L),
        Bird("까악", 2_000L),
        Bird("짹짹", 3_000L),
    ).forEach {
        jobs.add(launch {
            while (true) {
                it.tweet()
            }
        })
    }

    end.join()
    jobs.forEach { it.cancel() }
}