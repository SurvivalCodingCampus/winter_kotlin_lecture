package day17

import kotlinx.coroutines.runBlocking
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.day17.data_source.movie.MovieDataSourceImpl
import org.example.day17.repository.movie.MovieRepositoryImpl
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class MovieTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `MockMovieDataSourceImol를 사용해서 테스트하기`(): Unit = runBlocking {
        val movieRepositoryImpl = MovieRepositoryImpl(MovieDataSourceImpl())
        val testMovieData = movieRepositoryImpl.getMovieInfoList()

//        // 가져온 Movie 개수 확인
//        assertEquals(1, testMovieData.size)
//
//        // 가져온 Movie 에 데이터가 정상적으로 들어있는지 확인
//        assertEquals(939243, testMovieData[0].id)
//        assertEquals("수퍼 소닉 3", testMovieData[0].title)
//        assertEquals("너클즈, 테일즈와 함께 평화로운 일상을 보내던 초특급 히어로 소닉...", testMovieData[0].overview)
//        assertEquals("2024-12-19", testMovieData[0].releaseDate)
//
//        // Movie의 releaseDate가 Json에서는 release_date로 표시되는지 확인
//        val checkSerialName = Json.encodeToString(testMovieData).indexOf("release_date")
//
//        assertEquals(true, checkSerialName != -1)
    }
}