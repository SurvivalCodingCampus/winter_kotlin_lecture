package day13

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class Bird(private val interval: Long, private val sound: String) {
    suspend fun chirp() = withContext(Dispatchers.Default) {
        while (true) {
            delay(interval)
            println(sound)
        }
    }
}

suspend fun chirping() = withContext(Dispatchers.Default) {
    val birds = listOf(
        Bird(1000L, "꾸우"),
        Bird(2000L, "까악"),
        Bird(3000L, "짹짹"),
    )
    val jobs = birds.map { launch { it.chirp() } }

    launch {
        jobs.forEach { it.start() }
        delay(10000L)
        jobs.forEach { it.cancel() }
    }
}