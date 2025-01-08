package day15.repository

import day15.data_source.MockPhotoDatasourceImpl
import kotlinx.coroutines.test.runTest
import kotlin.test.*

class PhotoRepositoryImplTest {
    @Test
    fun `albumId에 일치하는 Json데이터를 가져오는지 확인`() = runTest {
        val repository = PhotoRepositoryImpl(MockPhotoDatasourceImpl())
        val photos = repository.getPhotos(1)

        assertEquals(50, photos.size)
    }

}