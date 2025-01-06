package day13

import kotlinx.coroutines.*

/* 개선 전 코드
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
*/

class Bird(private val delay: Long, val sound: String) {
    suspend fun sound() {
        delay(delay)
        println(sound)
    }
}
fun main(): Unit = runBlocking {
    val bird1 = Bird(1000, "꾸우")
    val bird2 = Bird(2000, "까악")
    val bird3 = Bird(3000, "짹짹")

    val job1 = launch {
        while(true) {
            bird1.sound()
        }
    }
    val job2 = launch {
        while(true) {
            bird2.sound()
        }
    }
    val job3 = launch {
        while(true) {
            bird3.sound()
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

