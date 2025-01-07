package day14

import kotlinx.serialization.ExperimentalSerializationApi

@OptIn(ExperimentalSerializationApi::class)
class StockDataSourceImpl : StockDataSource {
    override suspend fun getStockListings(): List<StockListing> {
        return Data.stockListingString.drop(1).map {
            StockListingSerializer.decodeFromString(it)
        }.filter { it.name.isNotBlank() }
    }
}