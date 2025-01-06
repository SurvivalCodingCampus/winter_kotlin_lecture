package org.example.day14.stock

import java.time.LocalDate

data class Stock(
    val symbol: String,
    val name: String,
    val exchange: Exchange,
    val assetType: AssetType,
    val ipoDate: LocalDate,
    val delistingDate: LocalDate?,
    val isActive: Boolean
)