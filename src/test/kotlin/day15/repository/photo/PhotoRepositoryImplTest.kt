package day15.repository.photo

import day15.data_source.photo.MockPhotoDataSourceImpl
import day15.model.Photo
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals

class PhotoRepositoryImplTest {

    @Test
    fun `데이터 size 체크 및 데이터 확인`() = runBlocking {
        val photoRepositoryImpl = PhotoRepositoryImpl(MockPhotoDataSourceImpl())

        val result = photoRepositoryImpl.getPhotos(1)

        // size 체크
        assertEquals(50, result.size)

        // 첫번째 데이터 값 일치 확인
        assertEquals(
            Photo(
                albumId = 1,
                id = 1,
                title = "accusamus beatae ad facilis cum similique qui sunt",
                url = "https://via.placeholder.com/600/92c952",
                thumbnailUrl = "https://via.placeholder.com/150/92c952"
            ),
            result.first()
        )
    }

}