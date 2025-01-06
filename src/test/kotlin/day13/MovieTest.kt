package day13

import org.junit.Assert.*
import org.junit.Test
import day13.getMovieInfo
import kotlinx.coroutines.runBlocking

class MovieTest {
    @Test
    fun movieTest() = runBlocking {
        val movie = getMovieInfo()

        assertEquals("Star Wars", movie.title)
        assertEquals("George Lucas", movie.director)
        assertEquals(1977, movie.year)
    }
}