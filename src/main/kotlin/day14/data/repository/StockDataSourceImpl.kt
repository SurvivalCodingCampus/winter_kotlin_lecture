package org.example.day14.data.repository

import org.example.day14.data.model.StockListing
import java.io.File
import java.io.FileNotFoundException

class StockDataSourceImpl : StockDataSource {
    override fun getStockListings(): List<StockListing> {
        val file = File("src/main/kotlin/day14/data/resources/listing_status.csv")

        if (!file.exists()) throw FileNotFoundException()

        return file.readLines().drop(1).map {
            val values = it.split(" ")
            StockListing(
                values.getOrNull(0),
                values.getOrNull(1),
                values.getOrNull(2),
                values.getOrNull(3),
                values.getOrNull(4),
                values.getOrNull(5),
                values.getOrNull(6),
            )
        }
    }
}