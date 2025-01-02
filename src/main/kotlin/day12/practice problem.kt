package day12

import kotlinx.serialization.Serializable
import java.io.File
import java.time.LocalDateTime
import kotlinx.serialization.json.Json


fun main() {
    val file = File("practice problem.txt")
    val text = file.readText()
    println(text)
}

/*@Serializable
class test {
    lateinit var collectionChartDataList: List<collection>
}

@Serializable
class collection(var collectionName: String, var collectionSalePrice: salePrice?) {

}

@Serializable
class salePrice(var price: Double, var cvtDatetime: LocalDateTime) {
}*/

/*
* 해당 json 문법을 보고 처음에는 null이 문제가 될거라 생각해서 예외로 잘 받거나 하면 되지 않나 생각하였으나,
* 그것보다는 cvtDatetime 변수의 타입이 문제였다.
* 해당 자료형은 LocalDateTime으로 예상이 되고 이는 java 패키지로 분류가 되어
* 코틀린에서 제공하는 json 직렬화 방식을 가져다 사용할 수가 없었다.
* 그래서 파싱을 하려면 따로 해당 클래스에서 fromJson이라는 메소드를 만들어 수동으로 역직렬화를 해주어야 하는 것이 문제였다.
* 이 문제를 해결하려면 수동으로 파싱을 해주거나 아니면 클래스 내부 변수를 코틀린에서 직렬화를 지원해주는 형식으로 바꾸어야 할 듯 하다.
*   {
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
 */

