package day17.repository

import day17.dto.ContentDto
import kotlinx.coroutines.test.runTest
import org.example.day17.data_source.ContentDataSource
import org.example.day17.model.ContentType
import org.example.day17.repository.ContentRepositoryImpl
import org.junit.Assert.assertEquals
import org.junit.Test

class ContentRepositoryImplTest {
    val mockContentDataSource = object : ContentDataSource {
        override suspend fun getContents(): List<ContentDto> =
            defaultJson.decodeFromString<List<ContentDto>>(fakeJsonString)
    }

    @Test
    fun getContents() = runTest {
        val contentRepository = ContentRepositoryImpl(mockContentDataSource)
        val contents = contentRepository.getContents()
        assertEquals(6, contents.size)
        assertEquals(1, contents[3].id)
        assertEquals(ContentType.UNKNOWN, contents[4].type)
        assertEquals("", contents[0].url)
        assertEquals("", contents[1].content)
    }

    private val fakeJsonString =
        """[{"id": 1,"type": "article","title": "This is an article","content": "This is the content of the article.","created_at": "2020-01-01"},{"id": 2,"type": "image","url": "https://example.com/image.jpg","caption": "This is an image.","created_at": "2020-02-02"},{"id": 3,"type": "video","url": "https://example.com/video.mp4","caption": "This is a video.","created_at": "2020-03-03"},{  "id": "1",  "type": "article",  "title": "This is an article",  "content": "This is the content of the article.",  "created_at": "2020-01-01"},{"id": 2,"type": null,"url": "https://example.com/image.jpg","caption": "This is an image.","created_at": "2020-02-02"},{"id": 3,"url": "https://example.com/video.mp4","caption": "This is a video.","created_at": "2020-03-03"}]""".trimIndent()

}