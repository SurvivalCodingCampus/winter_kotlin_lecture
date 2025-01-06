package day13

import kotlinx.coroutines.runBlocking
import org.example.day13.Movie
import org.example.day13.getMovieInfo
import org.junit.Assert.assertEquals
import org.junit.Test

class ParseJsonToMovieTest {
    @Test
    fun `getMovieInfo() 테스트`() = runBlocking {
        val expectedData = Movie("Star wars", "George Lucas", 1977)
        assertEquals(expectedData, getMovieInfo())
    }
}