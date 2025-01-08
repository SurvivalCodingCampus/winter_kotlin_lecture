package day16.repository.image

import io.kotest.common.runBlocking
import org.example.day16.data_source.image.ImageDataSourceImpl
import org.example.day16.repository.image.ImageRepositoryImpl
import org.junit.After
import org.junit.Assert.*
import org.junit.Test

class ImageRepositoryImplTest {
    private val imageRepository = ImageRepositoryImpl(ImageDataSourceImpl())
    private val url = "https://blog.kakaocdn.net/dn/lavVc/btsuh46equu/snh6LeQyyqUoQSOqgtsbI0/img.png"
    private val path = "src/test/resources/test.png"
    private val directory = "src/test/resources"
    private val urls = listOf(
        "https://blog.kakaocdn.net/dn/lavVc/btsuh46equu/snh6LeQyyqUoQSOqgtsbI0/img.png",
        "https://miro.medium.com/v2/resize:fit:800/1*c-dfNp_RM7MLP95LhnAwWA.png"
    )

    @After
    fun tearDown() {
        val file = java.io.File(path)
        if (file.exists()) {
            file.delete()
        }
        val directory = java.io.File(directory)
        if (directory.exists()) {
            directory.listFiles().forEach { it.delete() }
        }
    }

    @Test
    fun saveImage() = runBlocking {
        imageRepository.saveImage(url, path)
        val file = java.io.File(path)
        assertTrue("경로에 파일이 존재해야한다.", file.exists())
    }

    @Test
    fun saveImages() = runBlocking {
        imageRepository.saveImages(urls, directory)
        val files = java.io.File(directory).listFiles()
        assertEquals("파일이 2개 저장되어야 한다.", 2, files.size)

        val fileNames = files.map { it.name }
        assertTrue("파일 이름에 '0_' 가 포함되어야 한다.", fileNames.contains("0_img.png"))
    }

    @Test
    fun saveImageIfNotExists() = runBlocking {
        val result = imageRepository.saveImageIfNotExists(url, path)
        assertTrue("파일이 저장되어야 한다.", result)

        val result2 = imageRepository.saveImageIfNotExists(url, path)
        assertFalse("파일이 이미 존재하므로 저장되지 않아야 한다.", result2)
    }

}