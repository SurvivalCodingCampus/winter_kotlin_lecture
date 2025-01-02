package day12

import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

/*
다음과 같은 데이터를 서버에서 받아서 처리해야 한다. 문제점이 있다면 생각해 보고 해결 방안을 고민해 보시오.
1. 날짜 → 우선 String으로 받은 후 날짜 데이터로 변환 필요
LocalDateTime을 사용하여 DateTimeFormatter를 사용하여 문자열을 LocalDateTime으로 변환

2. null 데이터 처리
List<CollectionSalePrice>? nullable 타입 사용하여 null 값 처리.

3. 데이터 구분
받아오는 JSON 데이터 형식은 변경할 수 없고, 데이터 클래스만 변경해야 한다면,
JSON 역직렬화 후에 pk를 추가하여 구분할 수 있도록 처리 필요

*/

@Serializable
data class CollectionChartDataList(
    val collectionChartDataList: List<CollectionChartData>
)

@Serializable
data class CollectionChartData(
    val collectionName: String,
    val collectionSalePrice: List<CollectionSalePrice>?,
    @Transient var pk: Int = -1 // 직렬화시 제외, 초기값 -1로, var로 수정 가능하도록
) {
    companion object {
        private var pkCounter = 0

        fun generatePk(): Int {
            return ++pkCounter
        }
    }

    init {
        pk = generatePk() // 객체 생성 시 pk 값 할당
    }
}

@Serializable
data class CollectionSalePrice(
    val price: Double,
    val cvtDatetime: String
)

fun main() {
    // 역직렬화
    val objString = File("JsonExam.txt").readText()
    val obj = Json.decodeFromString<CollectionChartDataList>(objString)
    println(obj)

    // obj 직렬화
    val newJson = Json.encodeToString(obj)
    println(newJson)

}
