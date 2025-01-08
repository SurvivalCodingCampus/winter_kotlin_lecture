package day15.repository.album

import io.kotest.common.runBlocking
import org.example.day15.data_source.albums.MockAlbumDataSourceImpl
import org.example.day15.repository.album.AlbumRepositoryImpl
import org.junit.Assert.assertEquals
import org.junit.Test

class AlbumRepositoryImplTest {
    val albumRepository = AlbumRepositoryImpl(MockAlbumDataSourceImpl())

    @Test
    fun getAlbums() = runBlocking {
        val albums = albumRepository.getAlbums()
        assertEquals("album 객체의 갯수는 100개 여야한다.", 100, albums.size)

        val limitedAlbums = albumRepository.getAlbums(10)
        assertEquals("album 객체의 갯수는 10개 여야한다.", 10, limitedAlbums.size)
    }

}