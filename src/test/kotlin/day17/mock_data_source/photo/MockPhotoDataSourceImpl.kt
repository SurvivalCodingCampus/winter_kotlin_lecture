package day17.mock_data_source.photo

import kotlinx.serialization.json.Json
import org.example.day17.data_source.photo.PhotoDataSource
import org.example.day17.dto.photo.PhotoDto

class MockPhotoDataSourceImpl : PhotoDataSource {
    private val testJson = """[
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
        },
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
    ]""".trimIndent()


    override suspend fun getAllPhotos(): List<PhotoDto> {
        return Json { ignoreUnknownKeys = true }.decodeFromString<List<PhotoDto>>(testJson)
    }
}