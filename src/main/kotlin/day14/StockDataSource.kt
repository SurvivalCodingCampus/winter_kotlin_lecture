package day14

interface StockDataSource {
    suspend fun getStockListings(): List<StockListing>
}