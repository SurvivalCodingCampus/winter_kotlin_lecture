package day14

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class StockListing(
    val symbol: String,
    val name: String,
    val exchange: String,
    val assetType: String,
    val ipoDate: LocalDate,
    val delistingDate: LocalDate?,
    val status: String,
)
