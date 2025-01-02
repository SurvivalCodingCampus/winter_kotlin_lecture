package org.hyunjung.day12

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class CollectionChart(val collectionId: Int, val collectionName: String, val collectionSalePrice: List<SalePrice>)

@Serializable
data class SalePrice(val price: Double, val cvtDatetime: String)

fun main() {
    val collectionChartDataList = """
        [
           {
             "collectionId": 1,
             "collectionName": "collectionName",
             "collectionSalePrice": []
           },
           {
             "collectionId": 2,
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
    """.trimIndent()

    val result = Json.decodeFromString<List<CollectionChart>>(collectionChartDataList)
    println(result.toString())
}