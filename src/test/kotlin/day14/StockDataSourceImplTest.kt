package day14

import kotlinx.coroutines.test.runTest
import kotlin.test.*

class StockDataSourceImplTest {

    @Test
    fun `CSV 데이터가 데이터클래스 리스트로 변환되는지 확인`() = runTest {
        val data = StockDataSourceImpl()
        val stockList = data.getStockListings()

        assertNotNull(stockList)
        assertTrue(stockList is List<StockListing>)
        assertEquals(11731, stockList.lastIndex)
    }
}