package day13

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext


class Bird(private val interval: Long, private val sound: String) {
    private val count = 4
    suspend fun chirp() = withContext(Dispatchers.Default) {
        repeat(count) {
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
    birds.map { async { it.chirp() } }
        .forEach { it.await() }
}