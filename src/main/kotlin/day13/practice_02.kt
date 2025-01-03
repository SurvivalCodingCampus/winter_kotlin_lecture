package day13

import kotlinx.coroutines.*

class FirstBird {
    suspend fun BirdSound() {
        delay(1000)
        println("꾸우")
    }
}

class SecondBird {
    suspend fun BirdSound() {
        delay(2000)
        println("까악")
    }
}

class ThirdBird {
    suspend fun BirdSound() {
        delay(3000)
        println("짹짹")
    }
}

fun main(): Unit = runBlocking {
    val bird1 = FirstBird()
    val bird2 = SecondBird()
    val bird3 = ThirdBird()

    val job = launch {
            bird1.BirdSound()
            bird2.BirdSound()
            bird3.BirdSound()
    }

    launch {
        delay(10000)
        job.cancel()
        println("stop it")
    }

}

