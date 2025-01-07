package day15

import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

class AlbumRepositoryImplTest {

    @Test
    fun getAlbums() = runBlocking {
        // limit 인자가 null인 경우
        val data1 = AlbumRepositoryImpl(MockAlbumDataSourceImpl()).getAlbums()

        assertEquals(100, data1.size)

        // limit 인자가 5인 경우
        val data2 = AlbumRepositoryImpl(MockAlbumDataSourceImpl()).getAlbums(5)

        assertEquals(5, data2.size)
    }
}