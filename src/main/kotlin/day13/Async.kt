package org.hyunjung.day13

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
    println(1)
    val job = launch { // launch a new coroutine and keep a reference to its Job
        delay(1000L)
        println("2")
    }
    println("3")
    job.join() // wait until child coroutine completes
    println("4")
}