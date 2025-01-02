package day12.exercise

import kotlinx.serialization.Contextual
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.contextual
import java.sql.Timestamp
import java.time.LocalDateTime

/*
* 다음과 같은 데이터를 서버에서 받아서 처리해야 한다. 문제점이 있다면 생각해보고 해결 방안을 고민해보시오.
*
* {
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

* */
/*
* 고민 결과 : 위와 같은 데이터를 받기 위해서 data class의 직렬화를 진행하였는데 dataTime 값이 기본타입이 아닌 참조타입인 경우에는 에러가 발생한다.
* 이유: 플러그인이 생성한 Serializer에는 LocalDateTime을 어떻게 Json으로 파싱할 것인지 정의된 것이 없다.
* 따라서 이를 파싱하기 위해서는 추가 구현이 필요한데 KSerializer 인터페이스 구현체를 추가로 구현해주어야 한다.
*
*
* 하지만, 이 방식은 매번 일일히 지정하기 어려움
* 따라서 Type에 맞춰서 알아서 변환이 가능한 @Contextual 어노테이션 사용
* */

fun main() {

    val json: Json = Json {
        serializersModule = SerializersModule {
            contextual(LocalDateTimeSerializer)
        }
    }

    val testData = CollectionSalePrice(
        cvtDatetime = LocalDateTime.now()
    )

    println(json.encodeToString(testData))
}


@Serializable
data class ChartData(
    val collectionChartDataList: List<CollectionChartDateList>
)

@Serializable
data class CollectionChartDateList(
    val collectionName: String,
    val collectionSalePrice: List<CollectionSalePrice>? = null
)

//@Serializable
//data class CollectionSalePrice(
//    val price: Double,
//    @Serializable(with = LocalDateTimeSerializer::class)
//    val cvtDatetime : LocalDateTime
//)


@Serializable
data class CollectionSalePrice(
    @Contextual
    val cvtDatetime: LocalDateTime
)



