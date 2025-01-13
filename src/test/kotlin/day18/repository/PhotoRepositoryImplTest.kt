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
//}
//
///*
//* runtest delay 무시. runBlocking은 delay거친 후 결과 나옴
//* */