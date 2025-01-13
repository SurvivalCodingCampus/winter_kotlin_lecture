package day17.repository

import Photo
import org.example.day17.data_source.photo.MockPhotoDataSource
import day17.PhotoDto
import kotlinx.coroutines.test.runTest
import org.example.day15.Utils.format
import org.junit.Test
import toPhoto


val mockJson2 = """
     [ { "id": 1, "type": "article", "title": "This is an article", "content": "This is the content of the article.", "created_at": "2020-01-01" }, { "id": 2, "type": "image", "url": "https://example.com/image.jpg", "caption": "This is an image.", "created_at": "2020-02-02" }, { "id": 3, "type": "video", "url": "https://example.com/video.mp4", "caption": "This is a video.", "created_at": "2020-03-03" } ] 
    
""".trimIndent()

val mockJson3 = """
    [ { "id": "1", "type": "article", "title": "This is an article", "content": "This is the content of the article.", "created_at": "2020-01-01" }, { "id": 2, "type": null, "url": "https://example.com/image.jpg", "caption": "This is an image.", "created_at": "2020-02-02" }, { "id": 3, "url": "https://example.com/video.mp4", "caption": "This is a video.", "created_at": "2020-03-03" } ]
""".trimIndent()

class PhotoRepositoryImplTest {
    private val mockPhotoDataSourceCase1 = object : MockPhotoDataSource {
        override suspend fun fetchPhotoData(): List<Photo> {
            return format.decodeFromString<List<PhotoDto>>(mockJson2).map { photo -> photo.toPhoto() }
        }
    }

    private val mockPhotoDataSourceCase2 = object : MockPhotoDataSource {
        override suspend fun fetchPhotoData(): List<Photo> {
            return format.decodeFromString<List<PhotoDto>>(mockJson3).map { photo -> photo.toPhoto() }
        }
    }


    @Test
    fun `test photo mock`(): Unit = runTest {
        val case1Result = mockPhotoDataSourceCase1.fetchPhotoData()
        case1Result.forEach { photo ->
            photo.content
        }
    }

    @Test
    fun `test photo mock2`(): Unit = runTest {
        val case2Result = mockPhotoDataSourceCase2.fetchPhotoData()

        case2Result.forEach { photo ->
            println(photo)
        }
    }
}