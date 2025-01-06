package org.example.day14.stock

import org.example.day14.LocalFileRepository

interface StockLocalFileRepository : LocalFileRepository {
    override val filePath: String
        get() = "src/main/resources/listing_status.csv"

    suspend fun getStockData(): List<Stock>
}