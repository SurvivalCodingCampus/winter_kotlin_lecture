package org.example.day12

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class CollectionChartDataList(
    val collectionChartDataList: List<CollectionData>
)

@Serializable
data class CollectionData(
    val collectionName: String,
    val collectionSalePrice: List<SalePrice>? = null
)

@Serializable
data class SalePrice(
    val price: Double,
    val cvtDatetime: String
)

fun main() {
    val data = """ {
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
}
"""


    val data2 = Json.decodeFromString<CollectionChartDataList>(data)
    println(data2)
}