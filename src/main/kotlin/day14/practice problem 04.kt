package day14.practice_problem_04

import java.io.File
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

@Serializable
data class StockListing(
    val symbol: String,
    val name: String,
    val exchange: String,
    val assetType: String,
    val ipoDate: String,
    val delistingDate: String,
    val status: String,
)

interface StockDataSource {
    suspend fun getStockListings(): List<StockListing>
}

class StockDataSourceImpl: StockDataSource {
    override suspend fun getStockListings(): List<StockListing> {
        val file = File("listing_status.csv")
        val rawData = file.readText().trimIndent()
        val data = rawData.split(",", "\n")

        val getData = mutableListOf<StockListing>()

        var count = 0

        for(i in 7 until data.size step 7) {
            getData.add(count++, StockListing(data[i], data[i + 1], data[i + 2], data[i + 3], data[i + 4], data[i + 5], data[i + 6]))
            //println(i)
        }
        return getData
    }
}
suspend fun main() {
    val file = File("listing_status.csv")
    val rawData = file.readText()
    val data = rawData.split(",")

    val stockListing = StockDataSourceImpl().getStockListings()

    println(stockListing)
}