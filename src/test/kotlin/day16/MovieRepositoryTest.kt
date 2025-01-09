package day16

import MockMovieDataSourceImpl
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals


class MovieRepositoryTest {
    @Test
    fun `movie mock test`(): Unit = runTest {
        val movieList = MockMovieDataSourceImpl().getMovieInfoList()

        assertEquals(movieList.size, 1)
        assertEquals(movieList[0].id, 939243)
        assertEquals(movieList[0].title, "수퍼 소닉 3")
        assertEquals(movieList[0].overview, "너클즈, 테일즈와 함께 평화로운 일상을 보내던 초특급 히어로 소닉...")

    }
}

