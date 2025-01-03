package org.example.day11.exam

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class Employee(var name: String, var age: Int)

@Serializable
data class Department(var name: String, var leader: Employee)

fun main() {
    val department = Department(
        name = "총무부",
        leader = Employee(
            name = "홍길동",
            age = 41,
        )
    )

    val json = Json.encodeToString(department)

    val json2 = myFunction(json)

    File("company.txt")

    val loadData = Json.decodeFromString<Department>(json)
    println(loadData)
}

fun myFunction(json: String): String {
    val result = json.replace("{", "[")
    return myFunction2(result)
}

fun myFunction2(json: String): String {
    return json.replace("}", "]")
}