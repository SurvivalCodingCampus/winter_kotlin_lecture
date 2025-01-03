package day13

import io.kotest.common.runBlocking
import org.example.day13.Movie
import org.junit.Test
import kotlin.system.measureTimeMillis
import kotlin.test.assertTrue

class MovieTest {
    val json = """{"title": "Star Wars", "director": "George Lucas", "year": 1977}"""

    @Test
    fun getMovie() = runBlocking {
        val time = measureTimeMillis {
            val movie = Movie.getMovieInfoFromJson(json)
            println(movie.director)
        }
        println("시간: $time")
        assertTrue(time > 1000, "시간이 1초 이상 걸림")

    }

}