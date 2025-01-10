package day17.repository

import day17.data_source.PhotoDataSource
import day17.dto.PhotoDto
import day17.model.PhotoType
import kotlinx.coroutines.test.runTest
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class PhotoRepositoryImplTest {

    private val mockPhotoDataSource = object : PhotoDataSource {
        override suspend fun getPhotoList(): List<PhotoDto> {
            val photoList = Json.decodeFromString<List<PhotoDto>>(json)

            if (photoList == null) {
                return emptyList()
            }
            return photoList
        }
    }

    @Test
    fun `Photo데이터 예외 필드 처리 후 잘 가져옴 확인`() = runTest {
        val repository = PhotoRepositoryImpl(mockPhotoDataSource)
        val photos = repository.getPhotoList()

        assertEquals(1, photos[0].id)
        assertEquals(PhotoType.Unknown, photos[1].type)
        assertEquals(PhotoType.Unknown, photos[2].type)
        assertEquals(3, photos.size)
    }

    private val json = """
        [
          {
            "id": "1",
            "type": "article",
            "title": "This is an article",
            "content": "This is the content of the article.",
            "created_at": "2020-01-01"
          },
          {
            "id": 2,
            "type": null,
            "url": "https://example.com/image.jpg",
            "caption": "This is an image.",
            "created_at": "2020-02-02"
          },
          {
            "id": 3,

            "url": "https://example.com/video.mp4",
            "caption": "This is a video.",
            "created_at": "2020-03-03"
          }
        ]
    """.trimIndent()
}