package day13

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.example.day13.Bird
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.system.measureTimeMillis

class BirdTest {
    val 꾸우Bird = Bird("꾸우", 1000L)
    val 까악Bird = Bird("까악", 2000L)
    val 짹짹Bird = Bird("짹짹", 3000L)
    @Test
    fun `sing 4 times`() = runBlocking {

        val result1 = async {
            꾸우Bird.singShort()
        }
        val result2 = async {
            까악Bird.singShort()
        }
        val result3 = async {
            짹짹Bird.singShort()
        }

        val time = measureTimeMillis {
            result1.await()
            result2.await()
            result3.await()
        }
        println("시간: $time")
        assertTrue(
            "시간이 ${짹짹Bird.soundDelay * Bird.SHORT_SING_COUNT}초 이상 걸림",
            time > 짹짹Bird.soundDelay * Bird.SHORT_SING_COUNT
        )
        println("bird1: ${result1.isActive}, bird2: ${result2.isActive}, bird3: ${result3.isActive}")
    }


    @Test
    fun `sing all day`() = runBlocking {

        val job1 = launch {
            꾸우Bird.singAllDay()
        }
        val job2 = launch {
            까악Bird.singAllDay()
        }
        val job3 = launch {
            짹짹Bird.singAllDay()
        }

        delay(10000)
        println("10초 지남")
        job1.cancel()
        job2.cancel()
        job3.cancel()

        assertTrue("10초 이후에는 새가 울면 안된다.", !job1.isActive && !job2.isActive && !job3.isActive)
    }


}