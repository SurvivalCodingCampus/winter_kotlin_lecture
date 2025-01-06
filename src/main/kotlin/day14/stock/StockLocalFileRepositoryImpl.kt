package org.example.day14.stock

import java.io.File

class StockLocalFileRepositoryImpl : StockLocalFileRepository {

    override suspend fun getStockData(): List<Stock> {
        val rwoData = File(filePath).readText()
        val data = StockParser.parse(rwoData)
        return StockMapper.fromDataList(data)
    }
}