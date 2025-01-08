package day16.repository

import day16.data_source.MockMovieDataSource
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class MovieRepositoryImplTest {
    @Test
    fun `성공케이스 - 영화 리스트를 정상적으로 반환`() = runTest {
        val mockDataSource = MockMovieDataSource()
        val movieRepository = MovieRepositoryImpl(mockDataSource)
        val result = movieRepository.getMovieInfoList()

        assertEquals(1, result.size)
        assertEquals("수퍼 소닉 3", result[0].title)
        assertEquals("2024-12-19", result[0].releaseDate)
    }

    @Test
    fun `네트워크 에러 케이스 - 예외 발생 시 에러발생 확인`() = runTest {
        val mockDataSource = MockMovieDataSource(shouldThrowException = true)
        val movieRepository = MovieRepositoryImpl(mockDataSource)

        // 예외가 발생하는지 확인
        assertFailsWith<Exception> {
            movieRepository.getMovieInfoList()
        }

    }
}