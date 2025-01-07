package day15.repository.album

import day15.data_source.album.MockAlbumDataSourceImpl
import kotlinx.coroutines.runBlocking
import kotlin.test.Test
import kotlin.test.assertEquals


class AlbumRepositoryImplTest {
    private val albumRepositoryImpl = AlbumRepositoryImpl(MockAlbumDataSourceImpl())

    @Test
    fun `limit을 지정하지 않았을 경우 모든 데이터를 가져오는지 확인`() = runBlocking {
        val result = albumRepositoryImpl.getAlbums()

        assertEquals(100, result.size)
    }

    @Test
    fun `limit을 지정하였을 경우 limit 개수 만큼 가져오는지 확인`() = runBlocking {
        val result = albumRepositoryImpl.getAlbums(5)

        assertEquals(5, result.size)
    }


}