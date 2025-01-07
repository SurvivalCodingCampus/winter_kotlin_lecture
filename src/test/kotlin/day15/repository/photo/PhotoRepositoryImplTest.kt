package day15.repository.photo

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.SerializationException
import org.example.day15.data_source.photo.MockPhotoDataSourceImpl
import org.example.day15.repository.photo.PhotoRepositoryImpl
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.jupiter.api.assertThrows

class PhotoRepositoryImplTest {
    private val jsonWithInvalidField = """
    [
        {
          "albumId": 1,
          "id": 1,
          "title": "accusamus beatae ad facilis cum similique qui sunt",
          "url": "https://via.placeholder.com/600/92c952",
          "thumbnailUrl": "https://via.placeholder.com/150/92c952",
          "invalidField": "invalid"
        }
    ]
    """.trimIndent()

    private val invalidJson = """
    [
        {
          "albumId": 1,
          "id": 1,
          "title": "accusamus beatae ad facilis cum similique qui sunt",
          "url": "https://via.placeholder.com/600/92c952",
          "thumbnailUrl": "https://via.placeholder.com/150/92c952",
    """.trimIndent()
    val photoRepositoryImpl = PhotoRepositoryImpl(MockPhotoDataSourceImpl())

    @Test
    fun getPhotos(): Unit = runBlocking {
        val albumId = 1
        val photos = photoRepositoryImpl.getPhotos(albumId)
        assertTrue("사진 정보는 50개 여야 한다.", photos.size == 50)
        assertTrue("첫번째 사진의 albumId는 1이여야 한다.", photos.first().albumId == albumId)

        val invalidPhotoRepositoryImpl = PhotoRepositoryImpl(MockPhotoDataSourceImpl(jsonWithInvalidField))
        val photosWithInvalidField = invalidPhotoRepositoryImpl.getPhotos(albumId)
        assertTrue("사진 정보는 1개 여야 한다.", photosWithInvalidField.size == 1)

        val errorPhotoRepositoryImpl = PhotoRepositoryImpl(MockPhotoDataSourceImpl(invalidJson))

        launch {
            assertThrows<SerializationException> { errorPhotoRepositoryImpl.getPhotos(albumId) }
        }.start()
    }

}