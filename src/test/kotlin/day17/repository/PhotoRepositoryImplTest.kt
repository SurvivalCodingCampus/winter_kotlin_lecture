package day17.repository

import day17.dataSource.MockPhotoDataSourceImpl
import day17.model.PhotoType
import kotlinx.coroutines.test.runTest
import org.junit.Test
import org.junit.Assert.*
import java.time.format.DateTimeFormatter

class PhotoRepositoryImplTest {
    private val mockDataSource = MockPhotoDataSourceImpl()
    private val repository = PhotoRepositoryImpl(mockDataSource)

    @Test
    fun checkResponsePhotoData() = runTest {
        val result = repository.responsePhotoData()
        assertEquals(6, result.size)
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

        val photo5 = result[4]
        assertEquals("2", photo5.id)
        assertEquals(PhotoType.Unknown, photo5.type)
        assertEquals("This is an image caption", photo5.caption)
        assertEquals("2020-02-02", photo5.createdAt.format(formatter))

        val photo6 = result[5]
        assertEquals("3", photo6.id)
        assertEquals(PhotoType.Unknown, photo6.type)
        assertEquals("", photo6.title)
        assertEquals("https://example.com/video.mp4", photo6.url)
        assertEquals("This is a video caption", photo6.caption)
        assertEquals("2020-03-03", photo6.createdAt.format(formatter))

    }
}
//todo 실패 케이스 - 날짜 없는 경우, 잘못된 경우
//todo 경계값 테스트 - 빈 결과, 최대 길이
//todo 다양한 타입에 대한 테스트 - type이 선택지에 없는 경우