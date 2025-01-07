package org.example.day14

import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import java.io.File

@Serializable
data class StockListing(
    val symbol: String,
    val name: String,
    val exchange: String,
    val assetType: String,
    val ipoDate: String,
    val delistingDate: String?,
    val status: String,
)

interface StockDataSource {
    suspend fun getStockListings(): List<StockListing>
}

class StockDataSourceImpl(private val filePath: String) : StockDataSource {
    override suspend fun getStockListings(): List<StockListing> {
        return File(filePath).useLines { lines ->
            lines.drop(1)
                .map { line ->
                    val tokens = line.split(",")
                    if (tokens[0].isBlank()) {
                        null // symbol 값이 없으면 null 반환
                    } else {
                        StockListing(
                            symbol = tokens[0],
                            name = tokens[1],
                            exchange = tokens[2],
                            assetType = tokens[3],
                            ipoDate = tokens[4],
                            delistingDate = tokens[5].takeIf { it != "null" },
                            status = tokens[6]
                        )
                    }
                }.filterNotNull() // null 값을 제거
                .toList()
        }
    }
}

fun main() = runBlocking {
    val dataSource = StockDataSourceImpl("listing_status.csv")
    val listings = dataSource.getStockListings()

    listings.forEach {
        println(it)
    }
}
