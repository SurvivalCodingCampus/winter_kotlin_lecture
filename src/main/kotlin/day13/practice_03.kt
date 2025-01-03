package day13

import kotlinx.coroutines.*

class FirstBird {
    suspend fun birdSound() {
        delay(1000)
        println("꾸우")
    }
}

class SecondBird {
    suspend fun birdSound() {
        delay(2000)
        println("까악")
    }
}

class ThirdBird {
    suspend fun birdSound() {
        delay(3000)
        println("짹짹")
    }
}

fun main(): Unit = runBlocking {
    val bird1 = FirstBird()
    val bird2 = SecondBird()
    val bird3 = ThirdBird()

    val job1 = async {
        while(true) {
            bird1.birdSound()
        }
    }
    val job2 = async {
        while(true) {
            bird2.birdSound()
        }
    }
    val job3 = async {
        while(true) {
            bird3.birdSound()
        }
    }

    launch {
        delay(10000)
        job1.cancel()
        job2.cancel()
        job3.cancel()
        println("stop it")
    }

}

