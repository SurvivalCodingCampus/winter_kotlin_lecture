package day13

import kotlinx.coroutines.runBlocking
import org.example.day13.getMovieInfo
import org.junit.Assert.*
import kotlin.test.Test

class MovieKtTest {
    @Test
    fun `getMovieInfo - director 값이 Georage Lucas 이어야 한다 `() = runBlocking {
        assertEquals("George Lucas", getMovieInfo().director)
    }
}