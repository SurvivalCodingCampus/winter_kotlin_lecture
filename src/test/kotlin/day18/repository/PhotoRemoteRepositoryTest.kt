package day18.repository

import day18.mock.photoMockEngine
import day18.resource.testPixabayApiKey
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import kotlinx.io.IOException
import org.example.day14.data.result.Result
import org.example.day14.util.jsonConfig
import org.example.day18.datasource.PixabayDataSource
import org.example.day18.repository.PhotoRemoteRepository
import org.example.day18.util.PhotoError
import org.junit.Before
import org.junit.Test
import kotlin.test.assertEquals

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
    fun getPhotos() = testScope.runTest {
        listOf("networkError", "emptyQuery", "serverError", "success").forEach { query ->
            when (val result = subject.getPhotos(query)) {
                is Result.Error -> {
                    when (result.exception) {
                        PhotoError.EmptyQuery -> {
                            assertEquals("emptyQuery", query)
                        }

                        is PhotoError.ServerError -> {
                            assertEquals("serverError", query)
                        }

                        is IOException -> {
                            assertEquals("networkError", query)
                        }
                    }
                }

                is Result.Success -> {
                    assertEquals("success", query)
                }

                Result.Loading -> {}
            }
        }
    }
}