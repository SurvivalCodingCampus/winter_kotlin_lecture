//package day18.dataSource
//
//import day18.util.PhotoError
//import day18.util.createMockEngine
//import io.ktor.client.*
//import io.ktor.client.engine.mock.*
//import io.ktor.client.request.*
//import io.ktor.http.*
//import kotlinx.coroutines.test.runTest
//import kotlinx.io.IOException
//import org.junit.Test
//
//import org.junit.Assert.*
//
//class PhotoDataSourceImplTest {
//
//    @Test
//    fun checkGetPhoto() = runTest {
//        val mockResponse = """
//        {
//            "total": 289294,
//            "totalHits": 500,
//            "hits": [
//                {
//                    "id": 7679117,
//                    "tags": "flower, stamens, hypericum",
//                    "largeImageURL": "https://pixabay.com/get/flower.jpg"
//                },
//                {
//                    "id": 6316445,
//                    "tags": "rapeseeds, yellow, flowers",
//                    "largeImageURL": "https://pixabay.com/get/rapeseeds.jpg"
//                }
//            ]
//        }
//        """.trimIndent()
//
//        val mockEngine = createMockEngine { request ->
//            respond(
//                content = mockResponse,
//                status = HttpStatusCode.OK,
//                headers = headersOf(
//                    HttpHeaders.ContentType, ContentType.Application.Json.toString()
//                )
//            )
//        }
//
//        val client = HttpClient(mockEngine)
//        val dataSource = PhotoDataSourceImpl(client)
//        val photos = dataSource.getPhoto("flowers")
//
//        assertEquals(2, photos.size)
//        assertEquals("flower, stamens, hypericum", photos[0].tags)
//        assertEquals("https://pixabay.com/get/flower.jpg", photos[0].largeImageURL)
//        assertEquals("rapeseeds, yellow, flowers", photos[1].tags)
//        assertEquals("https://pixabay.com/get/rapeseeds.jpg", photos[1].largeImageURL)
//    }
//
//    @Test
//    fun checkEmptyQuery() = runTest {
//        val mockEngine = createMockEngine { respondOk() }
//        val client = HttpClient(mockEngine)
//        val dataSource = PhotoDataSourceImpl(client)
//        try {
//            dataSource.getPhoto("")
//            fail("Expected empty query")
//        } catch (e: Exception) {
//            assertTrue(e is PhotoError.EmptyQuery)
//        }
//    }
//
//
//    @Test
//    fun checkIOException() = runTest {
//        val mockEngine = createMockEngine { throw IOException("Network error") }
//        val client = HttpClient(mockEngine)
//        val dataSource = PhotoDataSourceImpl(client)
//        try {
//            dataSource.getPhoto("test")
//            fail("Expected IOException")
//        } catch (e: Exception) {
//            assertTrue(e is IOException)
//        }
//    }
//
//    @Test
//    fun checkServerError() = runTest {
//        val mockEngine = createMockEngine {
//            respondError(HttpStatusCode.InternalServerError, "Server error")
//        }
//        val client = HttpClient(mockEngine)
//        val dataSource = PhotoDataSourceImpl(client)
//        try {
//            dataSource.getPhoto("test")
//            fail("Expected server error")
//        } catch (e: Exception) {
//            assertTrue(e is PhotoError.ServerError)
//            assertEquals("Server error", e.message)
//        }
//    }
//}