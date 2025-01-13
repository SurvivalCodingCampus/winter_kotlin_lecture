package day18.repository

import day18.dto.PhotoDto
import day18.dto.PixabayResponseDto
import io.kotest.common.runBlocking
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.day18.data_source.PhotoDataSourceImpl
import org.example.day18.error.PhotoError
import org.example.day18.model.PhotoOrder
import org.example.day18.repository.PhotoRepositoryImpl
import org.example.day18.util.Result
import org.example.day18.util.Result.Success
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class PhotoRepositoryImplTest {
    private val mockEngine = MockEngine { request ->
        when (request.url.toString()) {
            "https://pixabay.com/api/mock/?key=123&q=cat&order=popular" -> {
                respond(
                    Json.encodeToString(
                        PixabayResponseDto(
                            total = 1,
                            totalHits = 1,
                            hits = listOf(
                                PhotoDto(
                                    likes = 2
                                ),
                                PhotoDto(
                                    likes = 1
                                ),
                            )
                        )
                    )
                )
            }

            "https://pixabay.com/api/mock/?key=123&q=error&order=latest" -> {
                respond(
                    content = "Internal Server Error",
                    status = HttpStatusCode.InternalServerError,
                )
            }

            else -> {
                respond(
                    content = "IO Error",
                    status = HttpStatusCode.NotFound,
                )
            }
        }
    }
    val mockPhotoDataSource: PhotoDataSourceImpl = PhotoDataSourceImpl(
        baseUrl = "https://pixabay.com/api/mock",
        client = HttpClient(mockEngine),
        pixabayApiKey = "123"
    )


    @Test
    fun getPhotos() = runBlocking {
        val photoRepository = PhotoRepositoryImpl(mockPhotoDataSource)
        val result = photoRepository.getPhotos("cat", PhotoOrder.POPULAR)

        assertTrue("결과는 성공이어야 한다.", result is Success)

        val emptyQueryError = photoRepository.getPhotos("")
        assertEquals("빈 쿼리일 경우 EmptyError가 발생해야 한다.", (emptyQueryError as Result.Error).e, PhotoError.EmptyError)

        val networkError = photoRepository.getPhotos("error")
        assertEquals(
            "500 에러일 경우 ServerError가 발생해야 한다.",
            (networkError as Result.Error).e::class,
            PhotoError.ServerError::class
        )

        val serverError = photoRepository.getPhotos("invalid")
        assertEquals("400 에러일 경우 NetworkError가 발생해야 한다.", (serverError as Result.Error).e, PhotoError.NetworkError)
    }

}