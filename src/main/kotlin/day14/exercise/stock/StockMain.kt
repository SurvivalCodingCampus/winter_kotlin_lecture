package day14.exercise.stock

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.io.File
import java.io.FileNotFoundException

class StockDataSourceImpl : StockDataSource {
    override suspend fun getStockListings(): List<StockListing> {
        val file = File("listing_status.csv")

        // 파일이 존재하지 않을경우 예외 던지기
        if (!file.exists()) throw FileNotFoundException()

        // IO 작업을 선택하여 비동기 처리시 유용하도록 해준다.
        return withContext(Dispatchers.IO) {
            val data = file.readLines().map { it.split(",") }.drop(1)

            data.map { stockData ->
                StockListing(
                    symbol = stockData[0],
                    name = stockData[1],
                    exchange = stockData[2],
                    assetType = stockData[3],
                    ipoDate = stockData[4],
                    delistingDate = stockData[5],
                    status = stockData[6]
                )
            }
        }
    }

}


fun main(): Unit = runBlocking {
    val stockSource = StockDataSourceImpl()
    val result = stockSource.getStockListings()
    println(result)
}
