package day14.exercise.stock

interface StockDataSource {

    suspend fun getStockListings() : List<StockListing>
}