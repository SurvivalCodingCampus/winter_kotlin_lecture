package day13

import kotlinx.coroutines.*


fun main(): Unit = runBlocking {
    val bird1 = FirstBird()
    val bird2 = SecondBird()
    val bird3 = ThirdBird()

    async { repeat(4) { bird1.birdSound() } }
    async { repeat(4) { bird2.birdSound() } }
    async { repeat(4) { bird3.birdSound() } }
}