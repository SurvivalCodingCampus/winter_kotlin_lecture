package day13.exercise

import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test
import kotlin.test.assertEquals


class MovieTest {
    @Test
    fun `Movie의 director가 제대로 출력되는지 확인`() = runTest {
        val testJson = """
               {
               "title": "Star Wars",
               "director": "George Lucas",
               "year" : 1977
               }
           """.trimIndent()
        val movieDirector = getMovieInfo(testJson).director

        assertEquals("George Lucas", movieDirector)
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