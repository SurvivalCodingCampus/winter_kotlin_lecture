package org.example.day14.stock

import java.time.LocalDate

object StockMapper {
    fun fromData(data: StockData): Stock {
        return Stock(
            symbol = data.symbol ?: "",
            name = data.name ?: "",
            exchange = Exchange.fromString(data.exchange),
            assetType = AssetType.fromString(data.assetType),
            ipoDate = LocalDate.parse(data.ipoDate ?: "1900-01-01"),
            delistingDate = if (data.delistingDate != null) {
                if (data.delistingDate == "null") {
                    null
                } else {
                    LocalDate.parse(data.delistingDate)
                }
            } else {
                null
            },
            isActive = data.status == "Active"
        )
    }

    fun fromDataList(data: List<StockData>): List<Stock> {
        return data.map { fromData(it) }
    }
}