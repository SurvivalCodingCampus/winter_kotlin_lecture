package day18.repository

import day18.data_source.PhotoDataSource
import day18.dto.PhotoDto
import day18.model.Photo
import day18.utils.PhotoError
import kotlinx.coroutines.test.runTest
import kotlin.test.Test
import day18.utils.Result
import java.io.IOException
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PhotoRepositoryImplTest {
    // 빈 쿼리 Mock 객체
    private val emptyQueryMockPhotoDataSource = object : PhotoDataSource {
        override suspend fun getPhotoList(keyword: String): List<PhotoDto> {
            if (keyword.isBlank()) throw PhotoError.EmptyQuery
            return emptyList()
        }
    }

    // 서버 오류 Mock 객체
    private val serverErrorMockPhotoDataSource = object : PhotoDataSource {
        override suspend fun getPhotoList(keyword: String): List<PhotoDto> {
            // 서버 오류 시나리오
            throw IllegalStateException("Internal Server Error")
        }
    }

    // 네트워크 오류 Mock 객체
    private val networkErrorMockPhotoDataSource = object : PhotoDataSource {
        override suspend fun getPhotoList(keyword: String): List<PhotoDto> {
            // 네트워크 오류 시나리오
            throw IOException("Network Error")
        }
    }

    // 정상적인 데이터를 반환하는 Mock 객체
    private val normalMockPhotoDataSource = object : PhotoDataSource {
        override suspend fun getPhotoList(keyword: String): List<PhotoDto> {
            return listOf(mockPhotoDto)
        }
    }

    @Test
    fun `정상 요청시 성공 결과를 반환한다`() = runTest {
        val repository = PhotoRepositoryImpl(normalMockPhotoDataSource)
        val result = repository.getPhotoList("blue flowers")

        if (result is Result.Success) {
            val photoList: List<Photo> = result.data
            assertEquals(listOf("nature", "flowers"), photoList[0].tags)
        }
    }

    @Test
    fun `서버 에러시 ServerError를 반환한다`() = runTest {
        val repository = PhotoRepositoryImpl(serverErrorMockPhotoDataSource)
        val result = repository.getPhotoList("blue flowers")

        if (result is Result.Error) {
            assertTrue(result.e is PhotoError.ServerError)
            val serverError = result.e as PhotoError.ServerError
            assertEquals("Internal Server Error", serverError.message)
        }
    }

    @Test
    fun `빈 쿼리시 EmptyQuery 에러를 반환한다`() = runTest {
        val repository = PhotoRepositoryImpl(emptyQueryMockPhotoDataSource)
        val result = repository.getPhotoList("")

        if (result is Result.Error)
            assertTrue(result.e is PhotoError.EmptyQuery)
    }

    @Test
    fun `네트워크 에러시 IOException을 반환한다`() = runTest {
        val repository = PhotoRepositoryImpl(networkErrorMockPhotoDataSource)
        val result = repository.getPhotoList("blue flowers")

        if (result is Result.Error)
            assertTrue(result.e is PhotoError.NetworkError)
    }

    private val mockPhotoDto = PhotoDto(
        id = 1L,
        pageURL = "http://example.com/photo.jpg",
        type = "photo",
        tags = "nature,flowers",
        previewURL = "http://example.com/photo_preview.jpg",
        previewWidth = 200,
        previewHeight = 200,
        webformatURL = "http://example.com/photo_web.jpg",
        webformatWidth = 600,
        webformatHeight = 600,
        largeImageURL = "http://example.com/photo_large.jpg",
        imageWidth = 1000,
        imageHeight = 1000,
        imageSize = 1024,
        views = 100,
        downloads = 50,
        collections = 10,
        likes = 20,
        comments = 5,
        user_id = 123L,
        user = "exampleUser",
        userImageURL = "http://example.com/user.jpg"
    )

}