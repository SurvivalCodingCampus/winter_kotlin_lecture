package day15

import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

class AlbumRepositoryImplTest {
    @Test
    fun `getAlbums should return all albums when limit is not specified`() = runBlocking {
        // limit 인자가 null인 경우
        val data1 = AlbumRepositoryImpl(MockAlbumDataSourceImpl()).getAlbums()

        assertEquals(100, data1.size)
    }

    @Test
    fun `getAlbums should return limited number of albums when limit is specified`() = runBlocking {
        // limit 인자가 5인 경우를 테스트
        val data2 = AlbumRepositoryImpl(MockAlbumDataSourceImpl()).getAlbums(5)

        assertEquals(5, data2.size)
    }
}