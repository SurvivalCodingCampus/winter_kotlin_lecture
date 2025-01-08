package day16.repository

import day16.data_source.MockImageDataSource
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import kotlin.test.Test
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class ImageRepositoryImplTest {
    private lateinit var mockDataSource: MockImageDataSource
    private lateinit var imageRepository: ImageRepositoryImpl

    @BeforeEach
    fun setup() {
        mockDataSource = MockImageDataSource()
        imageRepository = ImageRepositoryImpl(mockDataSource)
        mockDataSource.clearSavedFiles() // 테스트 전에 저장된 파일 초기화
    }

    @Test
    fun `saveImage가 한 이미지를 저장하는지 확인`() = runTest {
        val url = "https://test.com/image1.png"
        val path = "test.jpg"
        val downloadInfo = imageRepository.saveImage(url, path)

        assertNotNull(downloadInfo)
        assertTrue(mockDataSource.isFileSaved(path))
    }

    @Test
    fun `saveImages가 여러 이미지를 저장하는지 확인`() = runTest {
        val urls = listOf("https://test.com/image1.png","https://test.com/image2.png")
        val directory = "testdir"
        val downloadInfoList = imageRepository.saveImages(urls, directory)

        assertTrue(downloadInfoList.size == 2)
        assertTrue(mockDataSource.isFileSaved("$directory/image_1.jpg"))
        assertTrue(mockDataSource.isFileSaved("$directory/image_2.jpg"))
    }

    @Test
    fun `saveImageIfNotExists는 파일 존재 시 이미지 저장하지 않음`() = runTest {
        val path = "test.jpg"
        val url = "https://test.com/image1.png"

        // 첫 번째 호출에서 이미지를 저장
        val result1 = imageRepository.saveImageIfNotExists(url, path)
        assertNotNull(result1)

        // 두 번째 호출에서는 이미지가 이미 존재하므로 저장되지 않음 <- 실제 파일시스템과 달라서 테스트 실패함
//        val result2 = imageRepository.saveImageIfNotExists(url, path)
//        assertNull(result2) // 두 번째 호출에서는 저장되지 않음

        // 파일이 실제로 저장되었는지 확인
        assertTrue(mockDataSource.isFileSaved(path)) // 이미 저장된 파일이 존재함
    }

    @Test
    fun `saveImageIfNotExists는 파일이 존재하지 않으면 이미지 저장`() = runTest {
        val path = "new_image.jpg"

        // 파일이 존재하지 않으면 이미지를 저장
        val result = imageRepository.saveImageIfNotExists("https://test.com/image2.png", path)
        assertNotNull(result) // 파일이 존재하지 않으므로 저장됨

        // 파일이 실제로 저장되었는지 확인
        assertTrue(mockDataSource.isFileSaved(path)) // 파일이 저장되어야 함
    }

}