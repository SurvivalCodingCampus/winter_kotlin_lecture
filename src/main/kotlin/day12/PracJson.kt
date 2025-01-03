package day12

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.Date

val format = Json { ignoreUnknownKeys = true }


@Serializable
data class SalePrice(
    val price: Long,
    val cvtDateTime: String
)

@Serializable
data class DataList(
    val collectionName: String,
    val collectionSalePrice: List<SalePrice>?
)


@Serializable
data class CollectionDto(val collectionChartDataList: List<DataList>?)


fun main() {

    val result = Json.encodeToString(
        CollectionDto(
            listOf(
                DataList(
                    collectionName = "collectionName1",
                    collectionSalePrice = null
                ),
                DataList(
                    collectionName = "collectionName2",
                    collectionSalePrice = listOf(
                        SalePrice(5975L, "2023-03-26T08:08:35"),
                        SalePrice(6000L, "2023-03-26T08:08:45")
                    )
                )
            )
        )
    )
    println(result)


    try {

        val data = format.parseToJsonElement(
            """
        {
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
        )
        println(data)
    } catch (e: Exception) {
        println("json error")

    }
}

fun toJson() = """
        {
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
    """.trimIndent()


