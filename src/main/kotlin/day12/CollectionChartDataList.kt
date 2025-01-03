package org.example.day12

import kotlinx.serialization.Serializable

@Serializable
data class CollectionChartDataList(
    val collectionChartDataList: List<CollectionChartData>,
)