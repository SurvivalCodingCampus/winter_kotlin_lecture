package day13

import kotlinx.coroutines.runBlocking
import org.hyunjung.day13.getMovieInfo
import org.junit.Assert.*
import org.junit.Test

class MovieKtTest {
    @Test
    fun `Json에서 Movie 데이터를 리턴`() = runBlocking {
        val movie = getMovieInfo()

        assertEquals("Star Wars", movie.title)
        assertEquals("George Lucas", movie.director)
        assertEquals(1977, movie.year)
    }
}