package day14

import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertTrue
import org.junit.Test

class StockDataSourceImplTest {

    @Test
    fun stockListingsShouldContainMoreThan10000() = runTest {
        val stockData = StockDataSourceImpl()

        val stock = stockData.getStockListings()
        assertTrue(stock.size > 10000)
    }
}