package org.hyunjung.day11

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
class Employee(var name: String, var age: Int)

@Serializable
class Department(var name: String, var leader: Employee)

fun main() {
    val name = "홍길동"
    val employee = Employee(name, 41)
    val department = Department(name, employee)

    File("src/main/kotlin/day11/company.txt").writeText(Json.encodeToString(department))
}