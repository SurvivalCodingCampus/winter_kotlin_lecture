package day17

import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import org.hyunjung.day17.photo.datasource.MockPhotoDataSourceImpl
import org.hyunjung.day17.photo.datasource.PhotoDataSource
import org.hyunjung.day17.photo.dto.PhotoDto
import org.junit.Assert.*
import org.junit.Test

class MockPhotoDataSourceTest {

    private val dataSource = MockPhotoDataSourceImpl()

    @Test
    fun `정상 데이터 테스트`() {
        val photos = dataSource.getPhotos()

        assertEquals(6, photos.size)
        assertEquals(1, photos[0].id)
        assertEquals("article", photos[0].type)
        assertEquals("This is an article", photos[0].title)
    }

    @Test
    fun `null타입 처리 테스트`() {
        val photos = dataSource.getPhotos()

        assertNull(photos[4].type)
        assertEquals(2, photos[4].id)
    }

    @Test
    fun `빈 JSON 배열 처리 테스트`() {
        val emptyJson = "[]"
        val dataSource = object : PhotoDataSource {
            override fun getPhotos(): List<PhotoDto> {
                return Json.decodeFromString(emptyJson)
            }
        }

        val photos = dataSource.getPhotos()

        assertTrue(photos.isEmpty())
    }

    @Test(expected = SerializationException::class)
    fun `잘못된 JSON 처리 테스트`() {
        val invalidJson = "[{id: 1, type: article}]"
        val dataSource = object : PhotoDataSource {
            override fun getPhotos(): List<PhotoDto> {
                return Json.decodeFromString(invalidJson)
            }
        }

        dataSource.getPhotos()
    }

    @Test(expected = IllegalArgumentException::class)
    fun `id가 유효하지 않을 경우 테스트`() {
        val invalidIdJson = """
            [
              {
                "id": "invalid_id",
                "type": "article",
                "title": "Invalid ID",
                "content": "This should throw an exception.",
                "created_at": "2020-01-01"
              }
            ]
        """.trimIndent()

        val dataSource = object : PhotoDataSource {
            override fun getPhotos(): List<PhotoDto> {
                return Json.decodeFromString(invalidIdJson)
            }
        }

        dataSource.getPhotos()
    }
}