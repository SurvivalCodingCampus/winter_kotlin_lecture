package day12

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

/*
다음과 같은 데이터를 서버에서 받아서 처리해야 한다. 문제점이 있다면 생각해 보고 해결 방안을 고민해 보시오.
1. 날짜 → 우선 String으로 받은 후 날짜 데이터로 변환 필요
LocalDateTime을 사용하여 DateTimeFormatter를 사용하여 문자열을 LocalDateTime으로 변환

2. null 데이터 처리
List<CollectionSalePrice>? nullable 타입 사용하여 null 값 처리.

3. price가 Double 형식이 아닌 경우 예외 처리
price 값을 Double로 변환 실패 시 예외를 던져 처리
*/

@Serializable
data class CollectionChartDataList(
    val collectionChartDataList: List<CollectionChartData>
)

@Serializable
data class CollectionChartData(
    val collectionName: String,
    val collectionSalePrice: List<CollectionSalePrice>?,
)

@Serializable
data class CollectionSalePrice(
    val price: Double,
    val cvtDatetime: String,
)

fun main() {
    val collection1 = CollectionSalePrice(59.75, "2023-03-26T08:08:35")
    val collection2 = CollectionSalePrice(60.00, "2023-03-26T08:08:45")
    val collectionChartData1 = CollectionChartData("collectionName", null)
    val collectionChartData2 = CollectionChartData("collectionName", listOf(collection1, collection2))
    val collectionChartDataList = CollectionChartDataList(listOf(collectionChartData1, collectionChartData2))
    val json = Json.encodeToString(collectionChartDataList)
    println(json)

    // 역직렬화
    val objString = File("JsonExam.txt").readText()
    val obj = Json.decodeFromString<CollectionChartDataList>(objString)
    println(obj)

    // obj 직렬화
    val newJson = Json.encodeToString(obj)
    println(newJson)

}
