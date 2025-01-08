package day15.repository

import kotlinx.coroutines.runBlocking
import org.example.day15.data_source.PhotoDataSource
import org.example.day15.data_source.PhotoDataSourceImpl
import org.example.day15.repository.PhotoRepository
import org.example.day15.repository.PhotoRepositoryImpl
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class PhotoRepositoryImplTest {
    private lateinit var repository: PhotoRepository
    private lateinit var mockDataSource: PhotoDataSource

    @Before
    fun setup() {
        mockDataSource = PhotoDataSourceImpl()
        repository = PhotoRepositoryImpl(mockDataSource)
    }

    @Test
    fun `albumId 1을 넣을 경우 50이 나와야 한다`() = runBlocking {
        val albumId = 1
        val albums = repository.getPhotos(albumId)
        assertEquals(50, albums.size)
    }

    @Test
    fun `albumId 없는 경우 0이 나와야 한다`() = runBlocking {
        val albumId = 999
        val albums = repository.getPhotos(albumId)
        assertEquals(0, albums.size)
    }
}