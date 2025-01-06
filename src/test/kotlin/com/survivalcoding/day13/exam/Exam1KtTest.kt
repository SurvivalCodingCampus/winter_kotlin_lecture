package com.survivalcoding.day13.exam

import com.survivalcoding.com.survivalcoding.day13.exam.getMovieInfo
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.system.measureTimeMillis

class Exam1KtTest {
    @Test
    fun `getMovieInfo() 는 영화정보를 잘 가져와야 한다`() = runTest {
        val time = measureTimeMillis {
            val movie = getMovieInfo()
        }

        println(time)
        // 체크
    }
}