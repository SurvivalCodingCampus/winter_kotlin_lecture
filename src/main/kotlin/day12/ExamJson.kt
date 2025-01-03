package day12

import day11.Department
import day11.Employee
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

val json = Json.encodeToString(Department("총무부", Employee("홍길동", 41)))  // Department 객체를 json 문자열로 직렬화

fun myFunction(json: String): String {
    var result = json.replace("{", "[")
    return result
}

fun myFunction2(json: String): String {
    return json.replace("}", "]")
}

fun main() {
    var json2 = myFunction(json)
    json2 = myFunction2(json2)
    println("원본 JSON: $json")
    println("변환된 JSON: $json2")
}