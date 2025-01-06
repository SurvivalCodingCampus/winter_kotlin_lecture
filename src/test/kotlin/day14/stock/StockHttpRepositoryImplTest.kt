package day14.stock

import kotlinx.coroutines.runBlocking
import org.example.day14.stock.StockLocalFileRepositoryImpl
import org.junit.Test

class StockHttpRepositoryImplTest {
    val stockHttpRepositoryImpl = StockLocalFileRepositoryImpl()

    @Test
    fun getStockData() = runBlocking {
        val stockData = stockHttpRepositoryImpl.getStockData()
        println(stockData)
    }

}