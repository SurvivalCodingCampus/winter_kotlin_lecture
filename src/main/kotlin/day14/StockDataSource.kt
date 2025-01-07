package day14

import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.File
import java.io.InputStream

/*
과제4. 주식 정보 데이터를 제공하는 데이터소스
문제가 있는 항목은 제외할 것
*/

interface StockDataSource {
    suspend fun getStockListings(): List<StockListing>
}

@Serializable
data class StockListing(
    val symbol: String,
    val name: String,
    val exchange: String,
    val assetType: String,
    val ipoDate: String,
    val delistingDate: String?,
    val status: String
)

class StockDataSourceImpl : StockDataSource {
    override suspend fun getStockListings(): List<StockListing> {
        val csvData = File("listing_status.csv").readLines().map { it.split(",") }
        val dataWithoutHeader = csvData.drop(1)
        val stockDataList = dataWithoutHeader.map { stockData ->
            StockListing(
                symbol = stockData[0],
                name = stockData[1],
                exchange = stockData[2],
                assetType = stockData[3],
                ipoDate = stockData[4],
                delistingDate = if (stockData[5] == "null") null else stockData[5],
                status = stockData[6]
            )
        }

        return stockDataList
    }
}
