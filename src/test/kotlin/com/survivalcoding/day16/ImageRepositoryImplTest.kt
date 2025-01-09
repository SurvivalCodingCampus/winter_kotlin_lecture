package com.survivalcoding.day16

import com.survivalcoding.com.survivalcoding.day16.ImageDataSource
import com.survivalcoding.com.survivalcoding.day16.ImageRepositoryImpl
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.io.File
import kotlin.io.path.absolutePathString
import kotlin.io.path.createTempDirectory

class ImageRepositoryImplTest {
    private val mockDataSource = object : ImageDataSource {
        override suspend fun fetchImage(url: String): ByteArray {
            when (url) {
                "http://test.com/test.png" -> {
                    return byteArrayOf(1, 2, 3)
                }

                "http://test.com/test1.png" -> {
                    return byteArrayOf(1, 1, 1)
                }

                "http://test.com/test2.png" -> {
                    return byteArrayOf(2, 2, 2)
                }

                "http://test.com/test3.png" -> {
                    return byteArrayOf(3, 3, 3)
                }

                else -> return byteArrayOf(3, 4, 5)
            }
        }

        override suspend fun saveImage(bytes: ByteArray, path: String) {
            File(path).writeBytes(bytes)
        }

    }
    private val repository = ImageRepositoryImpl(mockDataSource)
    private lateinit var tempDirectory: String

    @Before
    fun setUp() {
        tempDirectory = createTempDirectory("image").absolutePathString()
    }

    @After
    fun tearDown() {
        File("test.png").delete()
        File(tempDirectory).deleteRecursively()
    }

    @Test
    fun saveImage() = runTest {
        repository.saveImage("http://test.com/test.png", "test.png")

        val file = File("test.png")
        assertTrue(file.exists())
        assertArrayEquals(byteArrayOf(1, 2, 3), file.readBytes())
    }

    @Test
    fun saveImages() = runTest {
        val urls = listOf(
            "http://test.com/test1.png",
            "http://test.com/test2.png",
            "http://test.com/test3.png",
        )

        repository.saveImages(urls, tempDirectory)


        val file = File("$tempDirectory/0.png")
        assertTrue(file.exists())
        assertArrayEquals(byteArrayOf(1, 1, 1), file.readBytes())
        val file2 = File("$tempDirectory/1.png")
        assertTrue(file.exists())
        assertArrayEquals(byteArrayOf(2, 2, 2), file2.readBytes())
        val file3 = File("$tempDirectory/2.png")
        assertTrue(file.exists())
        assertArrayEquals(byteArrayOf(3, 3, 3), file3.readBytes())
    }

    @Test
    fun saveImageIfNotExists() = runTest {
        // 없는 상태
        var result = repository.saveImageIfNotExists("http://test.com/test.png", "test.png")
        var file = File("test.png")
        assertTrue(result)
        assertTrue(file.exists())
        assertArrayEquals(byteArrayOf(1, 2, 3), file.readBytes())

        result = repository.saveImageIfNotExists("http://test.com/test.png", "test.png")
        assertTrue(file.exists())
        assertFalse(result)
        file = File("test.png")
        assertArrayEquals(byteArrayOf(1, 2, 3), file.readBytes())
    }
}