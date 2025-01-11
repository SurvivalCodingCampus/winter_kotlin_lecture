package day18.repository.photo

import kotlinx.coroutines.test.runTest
import day18.data_source.photo.MockPhotoDataSourceImpl
import kotlinx.io.IOException
import org.example.day18.repository.photo.PhotoRepositoryImpl
import org.example.day18.util.photo.Result
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class PhotoRepositoryImplTest {
    private val mockPhotoRepository = PhotoRepositoryImpl(MockPhotoDataSourceImpl())
    private val imageUrl1 =
        "https://pixabay.com/get/gd2c4c0f3c1699ef4713eea4e1217100f89d67bdfe15f876c1ba099c3ba627ae0258459c0b3c461c3f34a08498bbaf2aab08c5732603654ed2c266ae4e94f67d0_640.jpg"
    private val imageUrl2 =
        "https://pixabay.com/get/g41bdb221d025ae9ac4e5af769972f34f802afaa706d3cabf419b032d735c4ae338c25e1a80bc2851fcf523746cbebbebf554f1164da101d6f28e2482fa43f0d7_640.jpg"

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `정상적인 쿼리인 경우 테스트`() = runTest {
        val test = Result.checkPhotoError(mockPhotoRepository.getPhotos("cutedog"))


        // 가져온 Photo 개수 확인
        assertEquals(2, test.size)

        // Photo의 tags는 list<Sting>으로 정상적으로 저장했는지 확인
        assertEquals(listOf("puppy", "dog", "animal"), test[0].tags)
        assertEquals(listOf("puppy", "dog", "animal"), test[1].tags)

        // Photo의 url 정상적으로 저장했는지 확인
        assertEquals(imageUrl1, test[0].imageUrl)
        assertEquals(imageUrl2, test[1].imageUrl)
    }

    @Test
    fun `네트워크 에러 테스트`() = runTest {
        try {
            val test = mockPhotoRepository.getPhotos("network error")

            Result.checkPhotoError(test)
        } catch (e: IOException) {
            assertEquals("네트워크 에러", e.message)
        }

    }

    @Test
    fun `쿼리가 공백인 경우 IllegalArgumentException 테스트`() = runTest {
        try {
            val test = mockPhotoRepository.getPhotos("")

            Result.checkPhotoError(test)
        } catch (e: IllegalArgumentException) {
            assertEquals("빈 쿼리", e.message)
        }
    }

    @Test
    fun `서버 에러 500 테스트`() = runTest {
        try {
            val test = mockPhotoRepository.getPhotos("server error")

            println(Result.checkPhotoError(test))
        } catch (e: Exception) {
            assertEquals("서버 에러 (500)", e.message)
        }

    }
}