package org.example.day11

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class Employee(var name: String, var age: Int)

@Serializable
data class Department(var name: String, var leader: Employee)

fun main() {
    val name = "홍길동"
    val employee = Employee(name, 41)
    val department = Department(name, employee)

    File("company.txt").writeText(Json.encodeToString(department))
}