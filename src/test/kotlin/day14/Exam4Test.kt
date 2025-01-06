package day14

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.day14.StockDataSourceImpl
import org.example.day14.StockListing
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test

class Exam4Test {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `연습문제 4번 테스트`(): Unit = runBlocking {
        val test = StockDataSourceImpl()

        launch {
            assertEquals("A", test.getStockListings()[0].symbol)
            assertEquals("Agilent Technologies Inc", test.getStockListings()[0].name)
            assertEquals("NYSE", test.getStockListings()[0].exchange)
            assertEquals("Stock", test.getStockListings()[0].assetType)
            assertEquals("1999-11-18", test.getStockListings()[0].ipoDate)
            assertEquals("null", test.getStockListings()[0].delistingDate)
            assertEquals("Active", test.getStockListings()[0].status)

            // 직렬화 테스트
            val json = Json.encodeToString(test.getStockListings()[0])
            val jsonTest =
                """{"symbol":"A","name":"Agilent Technologies Inc","exchange":"NYSE","assetType":"Stock","ipoDate":"1999-11-18","delistingDate":"null","status":"Active"}""".trimIndent()

            assertEquals(jsonTest, json)

            // 역직렬화 테스트
            val data = Json.decodeFromString<StockListing>(json)

            assertEquals("A", data.symbol)
            assertEquals("Agilent Technologies Inc", data.name)
            assertEquals("NYSE", data.exchange)
            assertEquals("Stock", data.assetType)
            assertEquals("1999-11-18", data.ipoDate)
            assertEquals("null", data.delistingDate)
            assertEquals("Active", data.status)

        }
    }
}