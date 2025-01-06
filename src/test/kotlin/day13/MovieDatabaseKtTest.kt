package day13

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class MovieDatabaseKtTest {

    @Test
    fun `movie info parsed correctly`() = runTest {
        val expected = Movie("Star Wars", "George Lucas", 1977)
        assertEquals(expected, getMovieInfo())
    }
}