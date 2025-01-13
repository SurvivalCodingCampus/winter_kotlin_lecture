package day18.repository

import day18.mock.photoMockEngine
import day18.resource.testPixabayApiKey
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.example.day14.data.result.Result
import org.example.day14.util.jsonConfig
import org.example.day18.datasource.PixabayDataSource
import org.example.day18.repository.PhotoRemoteRepository
import org.example.day18.util.PhotoError
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class PhotoRemoteRepositoryTest {
    @OptIn(ExperimentalCoroutinesApi::class)
    private val testScope = TestScope(UnconfinedTestDispatcher())
    private lateinit var subject: PhotoRemoteRepository
    private lateinit var httpClient: HttpClient

    @Before
    fun setUp() {
        httpClient = HttpClient(photoMockEngine) {
            install(ContentNegotiation) {
                json(jsonConfig)
            }
        }

        subject = PhotoRemoteRepository(
            PixabayDataSource(
                httpClient,
                testPixabayApiKey,
            )
        )
    }

    @Test
    fun `getPhotos() 네트워크 에러 테스트`() = testScope.runTest {
        val result = subject.getPhotos("networkError")
        assertTrue(result is Result.Error)
        assertTrue(result.exception is PhotoError.NetworkError)
    }

    @Test
    fun `getPhotos() 빈 검색어 테스트 `() = testScope.runTest {
        val result = subject.getPhotos("")
        assertTrue(result is Result.Error)
        assertTrue(result.exception is PhotoError.EmptyQuery)

        val result2 = subject.getPhotos("    ")
        assertTrue(result2 is Result.Error)
        assertTrue(result2.exception is PhotoError.EmptyQuery)
    }

    @Test
    fun `getPhotos() 서버 에러 테스트`() = testScope.runTest {
        val result = subject.getPhotos("serverError")
        assertTrue(result is Result.Error)
        assertTrue(result.exception.cause is PhotoError.ServerError)
        assertEquals(
            HttpStatusCode.InternalServerError.toString(),
            (result.exception.cause as PhotoError.ServerError).message
        )

    }

    @Test
    fun `getPhotos() 성공 시`() = testScope.runTest {
        val result = subject.getPhotos("success")
        assertTrue(result is Result.Success)
    }
}