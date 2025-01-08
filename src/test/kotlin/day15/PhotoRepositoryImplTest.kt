package day15

import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

class PhotoRepositoryImplTest {

    @Test
    fun getPhotos() = runBlocking {
        val data = PhotoRepositoryImpl(MockPhotoDataSourceImpl()).getPhotos(1)

        for(i in data.indices) {
            assertEquals(1, data[i].albumId)
        }
    }
}