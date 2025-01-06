package day14.exercise.stock

import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class StockDataSourceImplTest {
    @Test
    fun `주식 정보 데이터를 제공하는 데이터소스 테스트`() = runTest {
        val stockDataSourceImpl = StockDataSourceImpl()
        val result = stockDataSourceImpl.getStockListings()


        assertTrue(result.size >= 10000)
    }
}