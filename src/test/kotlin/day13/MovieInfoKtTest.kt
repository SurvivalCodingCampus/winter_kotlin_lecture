package day13

import kotlinx.coroutines.runBlocking
import org.example.day13.getMovieInfo
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class MovieInfoKtTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `director가 출력되는지 테스트`(): Unit = runBlocking {
        var outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        println(getMovieInfo().director)
        assertEquals("George Lucas", outputStream.toString().trim())

        System.setOut(System.out)
    }
}