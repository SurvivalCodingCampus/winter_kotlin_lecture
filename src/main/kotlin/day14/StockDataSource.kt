package day14

import kotlinx.serialization.Serializable
import java.io.File

// 저장하고 싶지 않은 프로퍼티에 static 키워드나 transient 키워드를 붙이면 제외할 수 있다.
@Serializable
data class StockListing (
    val symbol: String,
    val name: String,
    val exchange: String,
    val assetType: String,
    val ipoDate: String,
    val delistingDate: String?,
    val status: String
)

interface StockDataSource {
    suspend fun getStockListings(): List<StockListing>
}

class StockDataSourceImpl: StockDataSource {
    val file = File("C:\\koko\\winter_kotlin_study\\src\\main\\kotlin\\day14\\csv.txt")
    val lines = file.readLines()

    //    val headers = lines.first().split(",")
    val stockListing = lines.drop(1).map { line ->
        val row = line.split(",")
        StockListing(
            symbol = row[0],
            name = row[1],
            exchange = row[2],
            assetType = row[3],
            ipoDate = row[4],
            delistingDate = row[5],
            status = row[6]
        )
    }

    override suspend fun getStockListings(): List<StockListing> {
        return stockListing
    }
}
