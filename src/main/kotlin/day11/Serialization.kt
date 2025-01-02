package org.example.day11

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

fun main() {
    val employee = Employee("홍길동", 41)
    val department = Department("총무부", employee)

    val json = Json.encodeToString(department)
    println(json)

    val file = File("company.txt")
    file.writeText(json)


}

@Serializable
data class Employee(var name: String, var age: Int)

@Serializable
data class Department(var name: String, var leader: Employee)