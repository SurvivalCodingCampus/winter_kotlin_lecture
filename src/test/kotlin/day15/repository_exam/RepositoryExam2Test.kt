package day15.repository_exam

import kotlinx.coroutines.runBlocking
import org.example.day15.repository_exam.data_source.MockPhotoDatasourceImpl
import org.example.day15.repository_exam.repository.PhotoRepositoryImpl
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class RepositoryExam2Test {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `getPhotos(int albumId) 테스트`() = runBlocking {
        val test = PhotoRepositoryImpl(MockPhotoDatasourceImpl())

        // 가져온 Photo 개수 확인
        assertEquals(50, test.getPhotos(1).size)
        assertEquals(50, test.getPhotos(2).size)
        assertEquals(50, test.getPhotos(3).size)

        // 가져온 Photo에서 원하는 데이터가 나오는지 확인
        assertEquals(1, test.getPhotos(1)[0].albumId)
        assertEquals(1, test.getPhotos(1)[0].id)
        assertEquals("accusamus beatae ad facilis cum similique qui sunt", test.getPhotos(1)[0].title)
        assertEquals("https://via.placeholder.com/600/92c952", test.getPhotos(1)[0].url)
        assertEquals("https://via.placeholder.com/150/92c952", test.getPhotos(1)[0].thumbnailUrl)
    }
}