package day16.data.repository

import day16.data.mock.imageMockEngine
import day16.data.mock.imgUrlTests
import io.ktor.client.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.filterNot
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.example.day14.data.result.Result
import org.example.day14.data.result.asResult
import org.example.day16.data.datasource.ImageDataSourceImpl
import org.example.day16.data.repository.ImageRepositoryImpl
import org.junit.After
import org.junit.Before
import org.junit.Test
import java.io.File
import java.nio.file.FileAlreadyExistsException
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ImageRepositoryImplTest {
    @OptIn(ExperimentalCoroutinesApi::class)
    private val testScope = TestScope(UnconfinedTestDispatcher())
    private lateinit var subject: ImageRepositoryImpl
    private lateinit var httpClient: HttpClient
    private val directory = "testimg"

    @Before
    fun setUp() {
        httpClient = HttpClient(imageMockEngine)
        subject = ImageRepositoryImpl(
            ImageDataSourceImpl(
                httpClient
            )
        )
    }

    @After
    fun tearDown() {
        File(directory).deleteRecursively()
    }

    @Test
    fun saveImage() = testScope.runTest {
        subject.saveImage(imgUrlTests[0].url, directory)
            .asResult().filterNot { it == Result.Loading }.collect { result ->
                assertTrue(result is Result.Success)
                assertEquals("${imgUrlTests[0].byteArray.size}bytes", result.data.fileSize)
            }
    }

    @Test
    fun saveImages() = testScope.runTest {
        subject.saveImages(imgUrlTests.map { it.url }, directory)
            .asResult().filterNot { it == Result.Loading }.collect { result ->
                assertTrue(result is Result.Success)
                assertEquals(imgUrlTests.size, result.data.size)
            }
    }

    @Test
    fun saveImageIfNotExists() = runTest {
        subject.saveImageIfNotExists(imgUrlTests[1].url, directory)
            .asResult().filterNot { it == Result.Loading }.collect { result ->
                assertTrue(result is Result.Success)
                assertEquals("${imgUrlTests[1].byteArray.size}bytes", result.data?.fileSize)
            }
        subject.saveImageIfNotExists(imgUrlTests[1].url, directory)
            .asResult().filterNot { it == Result.Loading }.collect { result ->
                assertTrue(result is Result.Error)
                assertTrue(result.exception is FileAlreadyExistsException)
            }
    }
}