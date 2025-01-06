package day13

import kotlinx.coroutines.*


fun main(): Unit = runBlocking {
    val bird1 = Bird(1000, "꾸우")
    val bird2 = Bird(2000, "까악")
    val bird3 = Bird(3000, "짹짹")

    launch { repeat(4) { bird1.sound() } }
    launch { repeat(4) { bird2.sound() } }
    launch { repeat(4) { bird3.sound() } }
}