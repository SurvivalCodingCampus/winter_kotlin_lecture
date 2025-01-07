package day15.repository_exam

import kotlinx.coroutines.runBlocking
import org.example.day15.repository_exam.data_source.AlbumDatasourceImpl
import org.example.day15.repository_exam.model.user.Address
import org.example.day15.repository_exam.model.user.Company
import org.example.day15.repository_exam.model.user.Geo
import org.example.day15.repository_exam.repository.AlbumRepositoryImpl
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class RepositoryExam5Test {
    private val test = AlbumRepositoryImpl(AlbumDatasourceImpl())

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `getAlbums(int limit) limit 지정하지 않은 경우 테스트`() = runBlocking {

        // 가져온 Album 개수 확인
        assertEquals(100, test.getAlbums().size)

        // 가져온 Album에서 원하는 데이터가 나오는지 확인
        assertEquals(1, test.getAlbums()[0].userId)
        assertEquals(1, test.getAlbums()[0].id)
        assertEquals("quidem molestiae enim", test.getAlbums()[0].title)
    }

    @Test
    fun `getAlbums(int limit) limit 지정한 경우 테스트`() = runBlocking {

        // limit가 10인 경우 가져온 Album 개수 확인
        assertEquals(10, test.getAlbums(10).size)

        // limit가 10인 경우 가져온 Album에서 원하는 데이터가 나오는지 확인
        assertEquals(1, test.getAlbums(10)[0].userId)
        assertEquals(1, test.getAlbums(10)[0].id)
        assertEquals("quidem molestiae enim", test.getAlbums(10)[0].title)

        // limit가 5인 경우 가져온 Album 개수 확인
        assertEquals(5, test.getAlbums(5).size)

        // limit가 5인 경우 가져온 Album에서 원하는 데이터가 나오는지 확인
        assertEquals(1, test.getAlbums(5)[0].userId)
        assertEquals(1, test.getAlbums(5)[0].id)
        assertEquals("quidem molestiae enim", test.getAlbums(5)[0].title)
    }
}