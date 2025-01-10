import day16.dataSource.ImageDataSourceImpl
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.io.File

class ImageDataSourceImplTest {

    @Test
    fun checkFetchImage() = runBlocking {
        // Arrange
        val mockUrl = "https://example.com/image.jpg"
        val mockByteArray = byteArrayOf(1, 2, 3, 4, 5)

        // MockEngine 설정
        val mockEngine = MockEngine { request ->
            when(request.url.toString()) {
                mockUrl ->
                respond(
                    content = mockByteArray,
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, "image/jpeg")
                )
                else -> respond(
                    content = "잘못된 요청입니다.",
                    status = HttpStatusCode.NotFound,
                )
            }



        }

        // MockEngine을 사용하는 HttpClient
        val client = HttpClient(mockEngine)
        val imageDataSource = ImageDataSourceImpl(client)

        // Act
        val result = imageDataSource.fetchImage(mockUrl)

        // Assert
        assertTrue(result.contentEquals(mockByteArray)) // 반환된 ByteArray가 예상 값과 일치하는지 확인
    }

    @Test
    fun checkSaveImage(): Unit = runBlocking {
        // Arrange
        val mockBytes = byteArrayOf(1, 2, 3, 4, 5)
        val mockPath = "test_image.jpg"
        val file = File(mockPath)

        // 기존에 파일이 있다면 삭제
        if (file.exists()) {
            file.delete()
        }

        // MockEngine을 사용하지 않아도 되는 테스트
        val client = HttpClient(MockEngine { respondOk() }) // 불필요하지만 HttpClient 생성
        val imageDataSource = ImageDataSourceImpl(client)

        // Act
        imageDataSource.saveImage(mockBytes, mockPath)

        // Assert
        assertTrue(file.exists()) // 파일이 생성되었는지 확인
        assertTrue(file.readBytes().contentEquals(mockBytes)) // 저장된 파일의 내용이 원본과 일치하는지 확인

        // Clean-up
        file.delete()
    }
}
