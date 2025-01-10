package day17.datasource

import day17.repository.MediaRepositoryImpl
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class MediaRepositoryTest {

    @Test
    fun `irregular responses`() = runTest {
        val dynamicResource = MediaRepositoryImpl(MockMediaItemDataSource(dynamicJsonResponse))
        val malformedResource = MediaRepositoryImpl(MockMediaItemDataSource(malformedJsonResponse))
        Assert.assertEquals(3, dynamicResource.getAll().size)
        Assert.assertEquals(3, malformedResource.getAll().size)
        Assert.assertEquals(1, malformedResource.getAll()[0].id)
    }

    private val dynamicJsonResponse = """
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

    private val malformedJsonResponse = """
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