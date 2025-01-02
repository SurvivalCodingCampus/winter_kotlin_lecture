package org.example.day12

import kotlinx.serialization.Serializable

@Serializable
data class CollectionSalePrice(
    val price: Double,
    val cvtDatetime: String,
)