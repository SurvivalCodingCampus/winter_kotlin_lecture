package day17.datasource

import day17.dto.MediaDto
import kotlinx.serialization.json.Json

class MockMediaItemDataSource(private val jsonString: String? = null) : MediaItemDataSource {
    override suspend fun getItems(): List<MediaDto> {
        return Json.decodeFromString<List<MediaDto>>(jsonString ?: defaultTestData)
    }

    private val defaultTestData = """
        [
          {
            "id": 2,
            "type": null,
            "title": "This is an article",
            "content": "This is the content of the article.",
            "url": "https://example.com/image.jpg",
            "caption": "This is an image.",
            "created_at": "2020-02-02"
          }
        ]

    """.trimIndent()
}