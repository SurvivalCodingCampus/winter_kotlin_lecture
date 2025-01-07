package org.example.day14

import kotlinx.coroutines.joinAll
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
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

class StockDataSourceImpl : StockDataSource {

    private val file = File("listing_status.csv")
    private var csv = file.readLines().map { it.split(",") }.drop(1)

    fun makeStockListing(csv: List<String>): StockListing {
        return StockListing( csv[0], csv[1], csv[2], csv[3], csv[4], csv[5], csv[6])
    }

    override suspend fun getStockListings(): List<StockListing> {
        val stockListing: MutableList<StockListing> = mutableListOf()

        csv.forEach{
            stockListing.add(makeStockListing(it))
        }

        return stockListing
    }

}

fun main() = runBlocking {
    val test = StockDataSourceImpl()

    val job = launch {
        println(test.getStockListings())
        val json = Json.encodeToString(test.getStockListings())
        println(json)
    }

}