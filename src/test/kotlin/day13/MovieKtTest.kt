package day13

import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.jupiter.api.*
class MovieKtTest {

    @Test
    fun checkGetMovieInfo() = runBlocking {
        val movie = getMovieInfo()

        val expectedTitle = "Star wars"
        val expectedDirector = "George Lucas"
        val expectedYear = 1977

        assertEquals(expectedTitle, movie.title)
        assertEquals(expectedDirector, movie.director)
        assertEquals(expectedYear, movie.year)
    }
}
