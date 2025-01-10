package day16.repository

import day16.dataSource.ImageDataSource
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Test
import java.io.File
import kotlin.test.assertContentEquals
import kotlin.test.assertTrue

class ImageRepositoryImplTest {
    private val mockDataSource = object : ImageDataSource {
        override suspend fun fetchImage(url: String): ByteArray {
            return when (url) {
                "http://test.com/test1.png" -> byteArrayOf(1, 2, 3)
                "http://test.com/test2.png" -> byteArrayOf(2, 2, 2)
                "http://test.com/test3.png" -> byteArrayOf(3, 3, 3)
                else -> throw IllegalArgumentException("Unknown URL: $url")
            }
        }

        override suspend fun saveImage(bytes: ByteArray, path: String) {
            File(path).apply {
                parentFile?.mkdirs() // 상위 디렉토리 생성
                writeBytes(bytes)
            }
        }
    }

    private val repository = ImageRepositoryImpl(mockDataSource)

    @After
    fun tearDown() {
        File("image").deleteRecursively() // 테스트 후 생성된 파일 및 디렉토리 삭제
    }

    @Test
    fun saveImage() = runTest {
        repository.saveImage("http://test.com/test1.png", "image/0.png")
        val file = File("image/0.png")
        assertTrue(file.exists())
        assertContentEquals(byteArrayOf(1, 2, 3), file.readBytes())
    }

    @Test
    fun saveImages() = runTest {
        val urls = listOf(
            "http://test.com/test1.png",
            "http://test.com/test2.png",
            "http://test.com/test3.png",
        )
        repository.saveImages(urls, "image")

        val file1 = File("image/0.png")
        val file2 = File("image/1.png")
        val file3 = File("image/2.png")

        assertTrue(file1.exists())
        assertContentEquals(byteArrayOf(1, 2, 3), file1.readBytes())

        assertTrue(file2.exists())
        assertContentEquals(byteArrayOf(2, 2, 2), file2.readBytes())

        assertTrue(file3.exists())
        assertContentEquals(byteArrayOf(3, 3, 3), file3.readBytes())
    }

    @Test
    fun saveImageIfNotExists() = runTest {
        val path = "image/unique.png"

        // 이미지 저장
        repository.saveImageIfNotExists("http://test.com/test1.png", path)
        val file = File(path)
        assertTrue(file.exists())
        assertContentEquals(byteArrayOf(1, 2, 3), file.readBytes())

        // 동일 경로에 다시 저장 시도
        repository.saveImageIfNotExists("http://test.com/test2.png", path)
        assertContentEquals(byteArrayOf(1, 2, 3), file.readBytes()) // 기존 내용 유지 확인
    }
}
