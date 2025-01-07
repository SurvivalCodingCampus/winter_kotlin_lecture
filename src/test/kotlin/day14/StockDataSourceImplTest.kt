package day14

import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class StockDataSourceImplTest {

    @Test
    fun checkExist() {
        val stockDataSourceImpl = StockDataSourceImpl()
        runBlocking {
            val listings = stockDataSourceImpl.getStockListings()
            assertTrue(listings.isNotEmpty())
        }
    }

    @Test
    fun checkData() {
        val stockDataSourceImpl = StockDataSourceImpl()
        runBlocking {
            val listings = stockDataSourceImpl.getStockListings()
            val first = listings[0]
            assertEquals("A", first.symbol)
            assertEquals("Agilent Technologies Inc", first.name)
            assertEquals("NYSE", first.exchange)
            assertEquals("Stock", first.assetType)
            assertEquals("1999-11-18", first.ipoDate)
            assertEquals("null", first.delistingDate)
            assertEquals("Active", first.status)
        }
    }
}