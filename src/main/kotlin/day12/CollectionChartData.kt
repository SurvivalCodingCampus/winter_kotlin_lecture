package org.example.day12

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class CollectionSalePrice(
    val price: Double,
    val cvtDatetime: String,
)

@Serializable
data class CollectionChartData(
    val collectionName: String,
    val collectionSalePrice: List<CollectionSalePrice>?
)

fun main() {
    val serverData = """{
        "collectionChartDataList": [
        {
            "collectionName": "collectionName",
            "collectionSalePrice": null
        },
        {
            "collectionName": "collectionName",
            "collectionSalePrice": [
            {
                "price": 59.75,
                "cvtDatetime": "2023-03-26T08:08:35"
            },
            {
                "price": 60.00,
                "cvtDatetime": "2023-03-26T08:08:45"
            }
            ]
        }
        ]
    }"""


    val collectionChartDataList = mutableListOf<CollectionChartData>()
    Json.decodeFromString<Map<String, List<CollectionChartData>>>(serverData)
        .getOrDefault("collectionChartDataList", null)
        ?.let { list ->
            list.forEach {
                collectionChartDataList.add(it)
            }
        }
}