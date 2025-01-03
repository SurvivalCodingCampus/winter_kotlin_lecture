package org.example.day12

import kotlinx.serialization.Serializable

@Serializable
data class CollectionChartData(
    val collectionName: String,
    val collectionSalePrice: List<CollectionSalePrice>?,
)