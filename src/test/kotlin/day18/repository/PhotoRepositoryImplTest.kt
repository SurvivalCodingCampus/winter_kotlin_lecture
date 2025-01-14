//package day18.repository
//
//import ResultPhoto
//import day18.dataSource.MockPhotoDataSourceImpl
//import day18.dataSource.PhotoDataSourceImpl
//import day18.util.PhotoError
//import day18.util.Sample.TEST_URL
//import day18.util.createMockEngine
//import io.ktor.client.*
//import io.ktor.client.engine.mock.*
//import io.ktor.http.*
//import kotlinx.coroutines.test.runTest
//import org.junit.Assert.assertEquals
//import kotlin.test.Test
//
//class PhotoRepositoryImplTest {
//
//    @Test
//    fun serverErrorTest() = runTest {
//        val mockEngine = createMockEngine { request ->
//            if (request.url.toString() == TEST_URL) {
//                respondError(HttpStatusCode.InternalServerError)
//            } else {
//                respondBadRequest()
//            }
//        }
//        val photoRepositoryImpl = PhotoRepositoryImpl(MockPhotoDataSourceImpl(mockEngine))
//        val result = photoRepositoryImpl.getPhotos("friday")
//        print(result)
//    }
//
//    @Test
//    fun serverErrorTest() = runTest {
//        val mockEngine = createMockEngine { request ->
//            // request.url.toString()이 TEST_URL인 경우 서버 에러 응답을 반환
//            if (request.url.toString() == TEST_URL) {
//                respondError(HttpStatusCode.InternalServerError, "Server error")
//            } else {
//                respondBadRequest() // 다른 요청에 대해 BadRequest 응답
//            }
//        }
//
//        // MockPhotoDataSourceImpl 대신 PhotoDataSourceImpl을 사용할 수 있음
//        val client = HttpClient(mockEngine)
//        val dataSource = PhotoDataSourceImpl(client)
//        val photoRepositoryImpl = PhotoRepositoryImpl(dataSource)
//
//        val result = photoRepositoryImpl.getPhotos("friday")
//
//        // 서버 오류 처리 확인 (예: 서버 오류일 경우 PhotoError.ServerError 발생)
//        when (result) {
//            is ResultPhoto.Error -> {
//                assertEquals(PhotoError.ServerError::class, result.error::class)
//                assertEquals("Server error", result.error.message)
//            }
//            else -> {
//                // 정상적인 응답이 와서는 안됨
//                assert(false) { "Expected server error" }
//            }
//        }
//    }
//}
//
///*
//* runtest delay 무시. runBlocking은 delay거친 후 결과 나옴
//* */