package day13

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import org.example.day13.Bird
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.system.measureTimeMillis

class BirdTest {
    @Test
    fun `sing 4 times`() = runBlocking {
        val 꾸우Bird = Bird("꾸우", 1000L)
        val 까악Bird = Bird("까악", 2000L)
        val 짹짹Bird = Bird("짹짹", 3000L)

        val result1 = async {
            꾸우Bird.singFourTimes()
        }
        val result2 = async {
            까악Bird.singFourTimes()
        }
        val result3 = async {
            짹짹Bird.singFourTimes()
        }

        val time = measureTimeMillis {
            result1.await()
            result2.await()
            result3.await()
        }
        println("시간: $time")
        assertTrue("시간이 12초 이상 걸림", time > 12000)
    }
}