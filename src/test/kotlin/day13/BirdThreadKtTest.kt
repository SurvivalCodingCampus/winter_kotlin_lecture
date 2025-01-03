package day13

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.example.day13.bird1
import org.example.day13.bird2
import org.example.day13.bird3
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

class BirdThreadKtTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `1초마다 우는 새, 2초마다 우는 새, 3초마다 우는 새들이 총 4번 우는 테스트`() = runBlocking {

        var job1: Job = launch {
            val measueredTime = measureNanoTime {
                var count = 1
                repeat(4) {
                    if (it > 0) count++
                    bird1()
                }
                assertEquals(4, count)
            }
            assertEquals(4, measueredTime / 1000000000)
        }

        val job2: Job = launch {
            val measueredTime = measureNanoTime {
                var count = 1
                repeat(4) {
                    if (it > 0) count++
                    bird2()
                }
                assertEquals(4, count)
            }
            assertEquals(8, measueredTime / 1000000000)
        }

        val job3: Job = launch {
            val measueredTime = measureNanoTime {
                var count = 1
                repeat(4) {
                    if (it > 0) count++
                    bird3()
                }
                assertEquals(4, count)
            }
            assertEquals(12, measueredTime / 1000000000)
        }
    }

    @Test
    fun `10초동안 새들이 우는 테스트`() = runBlocking {

        val job1: Job = launch {
            var count = 0
            var totalTime1 = 0
            while (true) {
                val measueredTime = measureNanoTime { bird1() }

                count++

                totalTime1 += (measueredTime / 1000000000).toInt()

                when (count) {
                    // 10초동안 9~10번 실행됨
                    9 -> assertEquals(9, count)
                    10 -> assertEquals(10, count)
                }

                when(totalTime1) {
                    // 10초에 바로 코루틴이 중단되서 마지막 실행 시간이 더해지지 않음
                    9 -> assertEquals(9, totalTime1)
                }
            }
        }

        val job2: Job = launch {
            var count = 0
            var totalTime2 = 0
            while (true) {
                val measueredTime = measureNanoTime { bird2() }

                count++

                totalTime2 += (measueredTime / 1000000000).toInt()

                when (count) {
                    // 10초동안 4~5번 실행됨
                    4 -> assertEquals(4, count)
                    5 -> assertEquals(5, count)
                }

                when(totalTime2) {
                    // 10초에 바로 코루틴이 중단되서 마지막 실행 시간이 더해지지 않음
                    8 -> assertEquals(8, totalTime2)
                }
            }
        }

        val job3: Job = launch {
            var count = 0
            var totalTime3 = 0
            while (true) {
                val measueredTime = measureNanoTime { bird3() }

                count++

                totalTime3 += (measueredTime / 1000000000).toInt()

                when (count) {
                    // 10초동안 3번 실행됨
                    3 -> assertEquals(3, count)
                }

                when(totalTime3) {
                    // 10초에 바로 코루틴이 중단되서 마지막 실행 시간이 더해지지 않음
                    9 -> assertEquals(9, totalTime3)
                }
            }
        }

        val jobCancle: Job = launch {
            delay(10000)
            job1.cancel()
            job2.cancel()
            job3.cancel()
        }


    }
}