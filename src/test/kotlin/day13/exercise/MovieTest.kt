package day13.exercise

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals


class MovieTest {
    @Test
    fun `Movie의 director가 제대로 출력되는지 확인`() = runTest {
        val movieData = Movie(title = "Star Wars", director = "George Lucas", year = 1977)
        assertEquals(movieData, getMovieInfo(json))
    }

    @Test(expected = RuntimeException::class)
    fun `Json 파싱 오류 테스트`() = runTest {
        val testJson = """
            {
            "title": "Star Wars",
            "director": "George Lucas",
            "year" : "13.3"
            }
        """.trimIndent()

        getMovieInfo(testJson)
    }

}