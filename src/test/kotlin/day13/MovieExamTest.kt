package day13

import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals


class MovieExamTest {

    @Test
    fun `반환된 영화정보에서 감독명이 올바르게 반환되는지 확인`():Unit = runBlocking {
        val movieExam = MovieExam()

        val movie = movieExam.getMovieInfo()

        assertEquals("George Lucas", movie.director)
    }
}