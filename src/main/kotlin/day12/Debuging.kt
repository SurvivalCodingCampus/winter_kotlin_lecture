package day12

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

val jsonString = """
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

// 최상의 json 객체 정의
@Serializable
data class Root (val collectionChartDataList: List<CollectionChartData>)

//데이터를 서버에서 받아서 처리해야 한다. 문제점이 있다면 생각해 보고 해결 방안을 고민
@Serializable
data class CollectionChartData(
    val collectionName: String,
    val collectionSalePrice: List<SalePrice>?
)

@Serializable
data class SalePrice(
    val price: Double,
    val cvtDatetime: String
)

fun main() {
    try {
        val root = Json.decodeFromString<Root>(jsonString)
        root.collectionChartDataList.forEach { collectionChartData ->
            println("name: ${collectionChartData.collectionName}, salePrice: ${collectionChartData.collectionSalePrice}")
        }
    } catch (e: Exception) {
        println(e.message)
    }
}

/*
* 발생한 문제점
* 에러 : JsonDecodingException. Expected start of the array '[', but had '{' instead
* 원인 : json 문자열을 잘못된 데이터 타입으로 파싱하려고 했기 때문.
*       최상위가 객체 형태로 시작하고 있고 그 안에 배열이 포함되어 있기 때문에 배열로 바로 파싱 시도하면 오류 발생
* 해결방법 : 최상위 json 객체 클래스 정의
*
* */
