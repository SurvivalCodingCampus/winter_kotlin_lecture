package day17

import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.network.sockets.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking
import org.hyunjung.day17.maskstore.datasource.MaskStoreDataSource
import org.hyunjung.day17.maskstore.repository.MaskStoreRepository
import org.junit.Assert.*
import org.junit.Test

class MaskStoreDataSourceTest {
    @Test
    fun `getStores should return mapped list of Store objects`() = runBlocking {
        val mockEngine = MockEngine { request ->
            respond(
                content = """
                    {
                        "count": 2,
                        "stores": [
                            {
                            "addr": "서울특별시 강북구 솔매로 38 (미아동)",
                            "code": "11817488",
                            "created_at": "2020/07/03 11:00:00",
                            "lat": 37.6254369,
                            "lng": 127.0164096,
                            "name": "승약국",
                            "remain_stat": "plenty",
                            "stock_at": "2020/07/02 18:05:00",
                            "type": "01"
                            },
                            {
                            "addr": "서울특별시 강북구 삼양로 247 3층 (미아동)",
                            "code": "12856941",
                            "created_at": "2020/07/03 11:00:00",
                            "lat": 37.6255182,
                            "lng": 127.017747,
                            "name": "대지약국",
                            "remain_stat": "plenty",
                            "stock_at": "2020/07/03 10:45:00",
                            "type": "01"
                            }
                        ]
                    }
                """.trimIndent(),
                status = HttpStatusCode.OK,
                headers = headersOf("Content-Type", "application/json")
            )
        }
        val client = HttpClient(mockEngine)
        val dataSource = MaskStoreDataSource(client)
        val repository = MaskStoreRepository(dataSource)

        val result = repository.getStores()

        assertNotNull(result)
        assertEquals(2, result.size)
        assertEquals("승약국", result[0].name)
        assertEquals("서울특별시 강북구 솔매로 38 (미아동)", result[0].address)
        assertEquals("plenty", result[0].stockStatus)
    }

    @Test
    fun `404 에러 케이스`() = runBlocking {
        val mockEngine = MockEngine { request ->
            respond(
                content = "Not Found",
                status = HttpStatusCode.NotFound,
                headers = headersOf("Content-Type", "text/plain")
            )
        }
        val client = HttpClient(mockEngine)
        val dataSource = MaskStoreDataSource(client)
        val repository = MaskStoreRepository(dataSource)

        try {
            repository.getStores()
            fail("Expected Exception to be thrown")
        } catch (e: Exception) {
            assertEquals("404: Not Found", e.message)
        }
    }

    @Test
    fun `네트워크 에러 케이스`() = runBlocking {
        val mockEngine = MockEngine { request ->
            throw ConnectTimeoutException("Connection timed out")
        }
        val client = HttpClient(mockEngine)
        val dataSource = MaskStoreDataSource(client)
        val repository = MaskStoreRepository(dataSource)

        try {
            repository.getStores()
            fail("Expected ConnectTimeoutException to be thrown")
        } catch (e: ConnectTimeoutException) {
            assertTrue(e.message!!.contains("Connection timed out"))
        }
    }
}