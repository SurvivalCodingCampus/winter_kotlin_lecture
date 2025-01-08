package day15.repository

import day15.data_source.MockAlbumDatasourceImpl
import kotlinx.coroutines.test.runTest
import kotlin.test.*

class AlbumRepositoryImplTest {

    @Test
    fun `limit이 없을때 모든 Album JSON 데이터를 가져오는지 확인`() = runTest {
        val repository = AlbumRepositoryImpl(MockAlbumDatasourceImpl())
        val allAlbum = repository.getAlbums()

        assertEquals(100, allAlbum.size)
    }

    @Test
    fun `limit이 있을때 limit수만큼 Album JSON 데이터를 가져오는지 확인`() = runTest {
        val repository = AlbumRepositoryImpl(MockAlbumDatasourceImpl())

        val albums = repository.getAlbums(2)
        assertEquals(2, albums.size)
    }

    @Test
    fun `limit이 음수일 때 IllegalArgumentException이 발생하는지 확인`() = runTest {
        val repository = AlbumRepositoryImpl(MockAlbumDatasourceImpl())
        assertFailsWith<IllegalArgumentException> {
            repository.getAlbums(-1)
        }
    }

    @Test
    fun `limit이 전체 데이터 수보다 클 때 모든 데이터를 반환하는지 확인`() = runTest {
        val repository = AlbumRepositoryImpl(MockAlbumDatasourceImpl())
        val albums = repository.getAlbums(150)
        assertEquals(100, albums.size)
    }

    @Test
    fun `반환된 앨범 데이터의 내용이 올바른지 확인`() = runTest {
        val repository = AlbumRepositoryImpl(MockAlbumDatasourceImpl())
        val albums = repository.getAlbums(1)

        assertEquals(1, albums[0].id)
        assertNotNull(albums[0].title)
        assertTrue(albums[0].userId > 0)
    }

}