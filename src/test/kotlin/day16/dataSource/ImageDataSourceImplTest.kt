import day16.dataSource.ImageDataSourceImpl
import io.mockk.coEvery
import io.mockk.mockk
import io.ktor.client.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.File

class ImageDataSourceImplTest {

    private val client: HttpClient = mockk() // HttpClient Mock 객체 생성
    private val imageDataSource = ImageDataSourceImpl(client)

    @Test
    fun checkFetchImage() = runBlocking {
        // Arrange
        val mockUrl = "https://img1.daumcdn.net/thumb/R1280x0/?scode=mtistory2&fname=https%3A%2F%2Fblog.kakaocdn.net%2Fdn%2F3bsTh%2Fbtr4G7tAaM9%2FNfGQDyKXu9YLx2MmPNP9Gk%2Fimg.png"
        val mockByteArray = byteArrayOf(1, 2, 3, 4, 5) // 가상의 바이트 배열로 응답 설정

        val mockResponse: HttpResponse = mockk()
        coEvery { client[mockUrl] } returns mockResponse // HttpClient의 get 호출 Mocking
        coEvery { mockResponse.readBytes() } returns mockByteArray // Mock 응답 설정

        // Act
        val result = imageDataSource.fetchImage(mockUrl)

        // Assert
        assertTrue(result.contentEquals(mockByteArray)) // 반환된 ByteArray가 예상 값과 일치하는지 확인
    }

    @Test
    fun checkSaveImage(): Unit = runBlocking {
        // Arrange
        val mockBytes = byteArrayOf(1, 2, 3, 4, 5)
        val mockPath = "C:\\koko\\winter_kotlin_study\\src\\test\\kotlin\\day16\\img\\test_image.jpg"   // 저장될 파일 경로
        val file = File(mockPath)

        // 기존에 파일이 있다면 삭제
        if (file.exists()) {
            file.delete()
        }

        // Act
        imageDataSource.saveImage(mockBytes, mockPath)

        // Assert
        assertTrue(file.exists()) // 파일이 생성되었는지 확인
        assertTrue(file.readBytes().contentEquals(mockBytes)) // 저장된 파일의 내용이 원본과 일치하는지 확인

//        file.delete()
    }
}
