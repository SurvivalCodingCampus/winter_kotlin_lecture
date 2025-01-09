package day17.data_source

import day17.dto.PhotoDto
import kotlinx.serialization.json.Json

interface PhotoDataSource {
    suspend fun getPhotoList1(): List<PhotoDto>
    suspend fun getPhotoList2(): List<PhotoDto>
}

class MockPhotoDataSourceImpl: PhotoDataSource {
    private val data1 = """
        [
          {
            "id": 1,
            "type": "article",
            "title": "This is an article",
            "content": "This is the content of the article.",
            "created_at": "2020-01-01"
          },
          {
            "id": 2,
            "type": "image",
            "url": "https://example.com/image.jpg",
            "caption": "This is an image.",
            "created_at": "2020-02-02"
          },
          {
            "id": 3,
            "type": "video",
            "url": "https://example.com/video.mp4",
            "caption": "This is a video.",
            "created_at": "2020-03-03"
          }
        ]
    """.trimIndent()

    private val data2 = """
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

    override suspend fun getPhotoList1(): List<PhotoDto> {
        return Json.decodeFromString<List<PhotoDto>>(data1)
    }

    override suspend fun getPhotoList2(): List<PhotoDto> {
        return Json.decodeFromString<List<PhotoDto>>(data2)
    }
}