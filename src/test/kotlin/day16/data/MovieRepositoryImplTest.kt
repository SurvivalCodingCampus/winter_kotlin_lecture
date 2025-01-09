package day16.data

import day16.model.Movie
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import org.junit.Assert.assertEquals
import org.junit.Test

class MovieRepositoryImplTest {
    @Test
    fun `MovieRepository should retrieve`() = runTest {
        val fakeSource = MockMovieDataSource()
        val repo = MovieRepositoryImpl(fakeSource)

        val expected = Json.decodeFromString<Movie>(fakeSource.upcomingMovieJson)
        val subject = repo.getMovieInfoList()

        assertEquals(expected, subject)
    }
}