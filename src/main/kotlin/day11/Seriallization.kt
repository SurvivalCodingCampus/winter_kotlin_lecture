package day11

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class Employee(
    var name: String,
    var age: Int,
)

@Serializable
data class Department(var name: String, var leader: Employee)

fun main() {
    val department = Department("총무부", Employee("홍길동", 41))
    val jsonString = Json.encodeToString(department)
    val file = File("company.txt")
    file.writeText(jsonString)
}