package day17.data_source

import day17.dto.PhotoDto
import day17.model.Photo
import kotlinx.serialization.json.Json

class PhotoDataSourceImpl: PhotoDataSource {
    override suspend fun getPhotoList(): List<PhotoDto> {
        val photoList = Json.decodeFromString<List<PhotoDto>>(json)

        if (photoList == null) {
            return emptyList()
        }
        return photoList
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