package day11

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class Employee(var name: String, var age: Int)

@Serializable
data class Department(var name: String, var leader: Employee)

fun main() {
    val leader = Employee("홍길동", 41)
    val json = Json.encodeToString(Department("총무부", leader))
    println(json)  // {"name":"총무부","leader":{"name":"홍길동","age":41}}

    val sourceFile = File("company.txt")
    sourceFile.writeText(json)
}
