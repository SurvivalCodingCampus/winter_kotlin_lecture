package day14.exercise.stock

/*
* 주식 정보 데이터 클래스
* */
data class StockListing(
    val symbol: String,
    val name: String,
    val exchange: String,
    val assetType: String,
    val ipoDate: String,
    val delistingDate: String? = null,
    val status: String,
)
