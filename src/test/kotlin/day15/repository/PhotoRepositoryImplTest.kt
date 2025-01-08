package day15.repository

import day15.data_source.MockPhotoDatasourceImpl
import day15.data_source.PhotoDataSource
import day15.model.Photo
import kotlinx.coroutines.test.runTest
import java.io.IOException
import kotlin.test.*

class PhotoRepositoryImplTest {
    @Test
    fun `albumId에 일치하는 Json데이터를 가져오는지 확인`() = runTest {
        val repository = PhotoRepositoryImpl(MockPhotoDatasourceImpl())
        val photos = repository.getPhotos(1)

        assertEquals(50, photos.size)
    }

    @Test
    fun `존재하지 않는 앨범 ID로 조회시 빈 리스트를 반환한다`() = runTest {
        val repository = PhotoRepositoryImpl(MockPhotoDatasourceImpl())
        val photos = repository.getPhotos(999)
        assertTrue(photos.isEmpty())
    }

    @Test
    fun `음수 앨범 ID로 조회시 IllegalArgumentException이 발생한다`() = runTest {
        val repository = PhotoRepositoryImpl(MockPhotoDatasourceImpl())

        assertFailsWith<IllegalArgumentException> {
            repository.getPhotos(-1)
        }
    }

    @Test
    fun `데이터소스에서 예외 발생시 적절히 처리된다`() = runTest {
        // 예외를 발생시키는 mock 데이터소스 구현
        class ErrorMockPhotoDataSource : PhotoDataSource {
            override suspend fun getPhotos(): List<Photo> {
                throw IOException("Failed to fetch photos")
            }
        }

        val repository = PhotoRepositoryImpl(ErrorMockPhotoDataSource())

        assertFailsWith<IOException> {
            repository.getPhotos(1)
        }
    }

}