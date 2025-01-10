package day18.repository

import day16.util.createMockEngine
import day18.datasource.MockPhotoDataSourceImpl
import day18.utils.Const
import day18.utils.PhotoError
import day18.utils.ResponseResult
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.coroutines.test.runTest
import kotlinx.io.IOException
import org.junit.Assert.assertEquals
import kotlin.test.Test


/*
* 테스트 케이스
* 네트워크 에러(IO Exception)
* 빈 검색어 체크
* 서버 에러(500)
* 정상 검색 결과 반환
* */
class PhotoRepositoryImplTest {


    // 정상 테스트
    @Test
    fun `getPhotos 성공 케이스`() = runTest {
        val mockEngine = createMockEngine { request ->
            if (request.url.toString() == Const.TEST_BASE_URL) {
                respond(
                    content = """
                        {
                            "total": 2,
                            "totalHits": 2,
                            "hits": [
                                {
                                    "id": 1,
                                    "pageURL": "http://example.com/1",
                                    "type": "photo",
                                    "tags": "yellow flower",
                                    "previewURL": "http://example.com/preview1",
                                    "previewWidth": 200,
                                    "previewHeight": 200,
                                    "webformatURL": "http://example.com/webformat1",
                                    "webformatWidth": 400,
                                    "webformatHeight": 400,
                                    "largeImageURL": "http://example.com/large1",
                                    "imageWidth": 1920,
                                    "imageHeight": 1080,
                                    "imageSize": 123456,
                                    "views": 1000,
                                    "downloads": 500,
                                    "collections": 100,
                                    "likes": 100,
                                    "comments": 10,
                                    "user_id": 1,
                                    "user": "user1",
                                    "userImageURL": "http://example.com/user1"
                                },
                                {
                                    "id": 2,
                                    "pageURL": "http://example.com/2",
                                    "type": "photo",
                                    "tags": "yellow flower",
                                    "previewURL": "http://example.com/preview2",
                                    "previewWidth": 200,
                                    "previewHeight": 200,
                                    "webformatURL": "http://example.com/webformat2",
                                    "webformatWidth": 400,
                                    "webformatHeight": 400,
                                    "largeImageURL": "http://example.com/large2",
                                    "imageWidth": 1920,
                                    "imageHeight": 1080,
                                    "imageSize": 123456,
                                    "views": 1000,
                                    "downloads": 500,
                                    "collections": 100,
                                    "likes": 100,
                                    "comments": 10,
                                    "user_id": 2,
                                    "user": "user2",
                                    "userImageURL": "http://example.com/user2"
                                }
                            ]
                        }
                        """,
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.toString())
                )
            } else {
                respondBadRequest() // 다른 URL에는 에러 응답
            }
        }

        val photoRepositoryImpl = PhotoRepositoryImpl(MockPhotoDataSourceImpl(mockEngine))

        // 정상적인 요청에 대한 응답 확인
        val result = photoRepositoryImpl.getPhotos("yellow flowers")

        // 결과 검증
        assert(result is ResponseResult.Success)
        val successResult = result as ResponseResult.Success
        assertEquals(2, successResult.data.size)
    }

    @Test
    fun `빈 검색어 체크 테스트`() = runTest {
        val mockEngine = createMockEngine { request ->
            if (request.url.toString() == "https://pixabay.com/api/?key=48140147-a327051003c503566d8eefd82&q=yellow+flowers") {
                respond(
                    "",
                    status = HttpStatusCode.OK,
                    headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.toString())
                )
            } else {
                respondBadRequest()
            }

        }

        val photoRepositoryImpl = PhotoRepositoryImpl(MockPhotoDataSourceImpl(mockEngine))

        // 정상적인 요청에 대한 응답 확인
        val result = photoRepositoryImpl.getPhotos("")
        assert(result is ResponseResult.Failure)
        val failureResult = result as ResponseResult.Failure
        assertEquals(PhotoError.EmptyQuery, failureResult.error)
    }

    @Test
    fun `서버 에러 처리 테스트`() = runTest {
        val mockEngine = createMockEngine { request ->
            if (request.url.toString() == "https://pixabay.com/api/?key=48140147-a327051003c503566d8eefd82&q=yellow+flowers") {
                respond(
                    content = "{}",
                    status = HttpStatusCode.InternalServerError, // 500 서버 오류
                    headers = headersOf(HttpHeaders.ContentType, ContentType.Application.Json.toString())
                )
            } else {
                respondBadRequest()
            }
        }

        val photoRepositoryImpl = PhotoRepositoryImpl(MockPhotoDataSourceImpl(mockEngine))

        // 서버 에러 확인
        val result = photoRepositoryImpl.getPhotos("yellow flowers")
        assert(result is ResponseResult.Failure)
        val failureResult = result as ResponseResult.Failure
        assertEquals(PhotoError.ServerError("서버 에러"), failureResult.error)
    }

    @Test
    fun `네트워크 에러 테스트(IO Exception)`() = runTest {
        val mockEngine = createMockEngine {
            throw IOException()
        }

        val photoRepositoryImpl = PhotoRepositoryImpl(MockPhotoDataSourceImpl(mockEngine))

        val result = photoRepositoryImpl.getPhotos("yellow flowers")

        // 네트워크 에러로 Failure가 발생해야 함
        assert(result is ResponseResult.Failure)
        val failureResult = result as ResponseResult.Failure
        assert(failureResult.error is PhotoError.NetworkError)
    }
}