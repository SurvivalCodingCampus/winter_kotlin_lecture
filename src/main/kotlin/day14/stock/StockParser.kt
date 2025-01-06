package org.example.day14.stock

object StockParser {
    fun parse(csv: String): List<StockData> {
        return csv.lines().filterIndexed { index, _ -> index != 0 }.map { line ->
            val values = line.split(",").map { if (it == "null") null else it }

            StockData(
                symbol = values.getOrNull(0),
                name = values.getOrNull(1),
                exchange = values.getOrNull(2),
                assetType = values.getOrNull(3),
                ipoDate = values.getOrNull(4),
                delistingDate = values.getOrNull(5),
                status = values.getOrNull(6)
            )

        }
    }
}