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
}