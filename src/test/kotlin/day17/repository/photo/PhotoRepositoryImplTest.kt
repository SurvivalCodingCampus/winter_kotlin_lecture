package day17.repository.photo

import day17.mock_data_source.photo.MockPhotoDataSourceImpl
import kotlinx.coroutines.test.runTest
import org.example.day17.repository.photo.PhotoRepositoryImpl
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class PhotoRepositoryImplTest {
    private val photoRepository = PhotoRepositoryImpl(MockPhotoDataSourceImpl())

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `PhotoRepository가 응답 데이터 모델로 변환 테스트`() = runTest {
        val test = photoRepository.getAllPhotos()

        // type이 article인 경우
        assertEquals(1, test[0].id)
        assertEquals("article", test[0].type)
        assertEquals("This is an article", test[0].title)
        assertEquals("This is the content of the article.", test[0].content)
        assertEquals("", test[0].url)
        assertEquals("", test[0].caption)
        assertEquals("2020-01-01", test[0].createdAt.toString())


        // type이 image인 경우
        assertEquals(2, test[1].id)
        assertEquals("image", test[1].type)
        assertEquals("", test[1].title)
        assertEquals("", test[1].content)
        assertEquals("https://example.com/image.jpg", test[1].url)
        assertEquals("This is an image.", test[1].caption)
        assertEquals("2020-02-02", test[1].createdAt.toString())


        // type이 video인 경우
        assertEquals(3, test[2].id)
        assertEquals("video", test[2].type)
        assertEquals("", test[2].title)
        assertEquals("", test[2].content)
        assertEquals("https://example.com/video.mp4", test[2].url)
        assertEquals("This is a video.", test[2].caption)
        assertEquals("2020-03-03", test[2].createdAt.toString())


        // id가 정수형이 아닌 문자열로 들어온 경우
        assertEquals(false, test[3].id.equals("1"))
        assertEquals(true, test[3].id == 1)

        assertEquals(1, test[3].id)
        assertEquals("article", test[3].type)
        assertEquals("This is an article", test[3].title)
        assertEquals("This is the content of the article.", test[3].content)
        assertEquals("", test[3].url)
        assertEquals("", test[3].caption)
        assertEquals("2020-01-01", test[3].createdAt.toString())

        // type이 null인 경우
        assertEquals(2, test[4].id)
        assertEquals("unknown", test[4].type)
        assertEquals("", test[4].title)
        assertEquals("", test[4].content)
        assertEquals("https://example.com/image.jpg", test[4].url)
        assertEquals("This is an image.", test[4].caption)
        assertEquals("2020-02-02", test[4].createdAt.toString())

        // type 데이터가 없는 경우
        assertEquals(3, test[5].id)
        assertEquals("unknown", test[5].type)
        assertEquals("", test[5].title)
        assertEquals("", test[5].content)
        assertEquals("https://example.com/video.mp4", test[5].url)
        assertEquals("This is a video.", test[5].caption)
        assertEquals("2020-03-03", test[5].createdAt.toString())
    }
}