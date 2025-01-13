package day18.repository

import day18.data_source.*
import day18.model.Photo
import day18.util.PhotoError
import day18.util.Result
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.Assert.*


class PhotoRepositoryImplTest {

    @Test
    fun `네트워크 에러 테스트`() = runBlocking {
        val photoRepository = PhotoRepositoryImpl(MockPhotoDataSourceImplNetworkError())

        val data = photoRepository.getPhotos("food")

        assertTrue(data is Result.Error)
        if(data is Result.Error) {
            assertTrue(data.e is PhotoError.NetworkError)
        }
    }

    @Test
    fun `빈 검색어 체크 테스트`() = runBlocking {
        val photoRepository = PhotoRepositoryImpl(MockPhotoDataSourceImpl())

        val data = photoRepository.getPhotos("")

        assertTrue(data is Result.Error)
        if(data is Result.Error) {
            assertTrue(data.e is PhotoError.EmptyQuery)
        }
    }

    @Test
    fun `서버 에러 테스트`() = runBlocking {
        val photoRepository = PhotoRepositoryImpl(MockPhotoDataSourceImplTestServerError())

        val data = photoRepository.getPhotos("people")

        assertTrue(data is Result.Error)
        if(data is Result.Error) {
            assertTrue(data.e is PhotoError.ServerError)
        }
    }

    @Test
    fun `정상 검색 반환 테스트`() = runBlocking {
        val photoRepository = PhotoRepositoryImpl(MockPhotoDataSourceImpl())

        val data = photoRepository.getPhotos("food")

        assertTrue(data is Result.Success)
        if(data is Result.Success<List<Photo>>) {
            assertTrue(data.data.size > 10)

            assertEquals("spring roll", data.data[0].tags[0])
            assertEquals("roll", data.data[0].tags[1])
            assertEquals("food", data.data[0].tags[2])
            assertEquals("https://pixabay.com/get/gd76bd3ce9886d8d102a500af45f792063ee0511c8cdc0a1d803008ce5c23c8e3fe104ce11f96dc362ca76e3b37921fbd8484624b7082ac28450db8f151fc6650_640.jpg",
                data.data[0].imageUrl)
        }

    }
}