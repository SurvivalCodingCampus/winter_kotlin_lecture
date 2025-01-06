package org.example.day14.stock

import kotlinx.serialization.Serializable

@Serializable
data class StockData(
    val symbol: String?,
    val name: String?,
    val exchange: String?,
    val assetType: String?,
    val ipoDate: String?,
    val delistingDate: String?,
    val status: String?
)
