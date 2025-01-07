package day14.practice_problem_04_test

import day14.practice_problem_04.StockDataSourceImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test

import org.junit.Assert.*

class StockDataSourceImplTest {

    @Test
    fun getStockListings() = runBlocking {
        val stockListing = StockDataSourceImpl().getStockListings()

        // 데이터가 일정 수 이상 잘 들어 왔는지 확인
        assertTrue(stockListing.size >= 1000)
    }
}