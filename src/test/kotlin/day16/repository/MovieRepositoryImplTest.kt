package day16.repository

import day16.dataSource.MockMovieDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class MovieRepositoryImplTest {
    private lateinit var mockDataSource: MockMovieDataSourceImpl
    private lateinit var repository: MovieRepositoryImpl

    @Before
    fun setUp() {
        mockDataSource = MockMovieDataSourceImpl()
        repository = MovieRepositoryImpl(mockDataSource)
    }

    @Test
    fun getMovieInfoList(): Unit = runBlocking {
        // When
        val movies = repository.getMovieInfoList()

        // Then
        assertEquals(1, movies.size) // Mock 데이터는 1개의 영화만 포함
        assertEquals(939243, movies[0].id)
        assertEquals("수퍼 소닉 3", movies[0].title)
        assertEquals("2024-12-19", movies[0].releaseDate)
    }

}