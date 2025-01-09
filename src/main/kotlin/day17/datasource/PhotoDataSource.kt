package org.example.day17.datasource

import kotlinx.serialization.json.Json
import org.example.day17.dto.PhotoDto

interface PhotoDataSource {
    suspend fun getPhots(): List<PhotoDto>

}

class MockPhotoDataSourceImpl : PhotoDataSource {
    override suspend fun getPhots(): List<PhotoDto> {
        val json = Json { ignoreUnknownKeys = true }
        val result = json.decodeFromString<PhotoDto>(photoJson)
        return listOf(result)
    }
}

val photoJson = """
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