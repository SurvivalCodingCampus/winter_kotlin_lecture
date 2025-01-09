package day17.repository

import day17.data_source.MockPhotoDataSourceImpl
import day17.model.PhotoType
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

class PhotoRepositoryImplTest {

    @Test
    fun `동작 확인`() = runBlocking {
        val photoRepositoryImpl = PhotoRepositoryImpl(MockPhotoDataSourceImpl())

        val photoList = photoRepositoryImpl.getUsableStoreData1()

        assertEquals("This is an article", photoList[0].title)
        assertEquals("https://example.com/image.jpg", photoList[1].url)
        assertEquals("https://example.com/video.mp4", photoList[2].url)
    }

    @Test
    fun `예외 상황 대처 확인`() = runBlocking {
        val photoRepositoryImpl = PhotoRepositoryImpl(MockPhotoDataSourceImpl())

        val photoList = photoRepositoryImpl.getUsableStoreData2()

        assertEquals(1, photoList[0].id)
        assertEquals(PhotoType.Unknown, photoList[1].type)
        assertEquals(PhotoType.Unknown, photoList[2].type)
    }
}