package day11

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.encodeToJsonElement
import java.io.File

@Serializable
class Employee(
    var name: String,
    var age: Int
)

@Serializable
class Department(var name: String, var leader: Employee)

fun main() {
    val department = Department("good company", Employee("홍길동", 15))

    val json = Json.encodeToString(department)
    val file = File("company.txt")
    file.writeText(json)

    file.delete()   // 파일 내용 확인이 필요하면 이 코드를 주석처리
}