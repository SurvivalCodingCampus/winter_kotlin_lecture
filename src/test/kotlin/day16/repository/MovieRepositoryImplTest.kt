package day16.repository

import kotlinx.coroutines.runBlocking
import org.example.day16.datasource.MovieMockDataSourceImpl
import org.example.day16.repository.MovieRepositoryImpl
import org.junit.Assert.*
import org.junit.Test

class MovieRepositoryImplTest {
    @Test
    fun `MovleMockDat를 사용하여 데이터 비교`() = runBlocking {
        val mockDataSource = MovieMockDataSourceImpl()
        val repository = MovieRepositoryImpl(mockDataSource)

        val result = repository.getMovieInfoList()

        assertEquals(1, result.size)
        assertEquals("수퍼 소닉 3", result[0].title)
        assertEquals("너클즈, 테일즈와 함께 평화로운 일상을 보내던 초특급 히어로 소닉...", result[0].overview)
        assertEquals("2024-12-19", result[0].releaseDate)
    }
}