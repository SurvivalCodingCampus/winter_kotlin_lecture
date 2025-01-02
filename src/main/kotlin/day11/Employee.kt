package day11

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

// 총무부 리더 ‘홍길동(41세)’의 인스턴스를 생성하고
// JSON으로 직렬화하여
// company.txt 파일에 저장하는 프로그램을 작성하시오.

fun main() {
    val json = Json.encodeToString(Department("총무부", Employee("홍길동", 41)))
    println(json)

    val file = File("C:\\koko\\winter_kotlin_study\\src\\main\\kotlin\\day11\\company.txt")
    file.writeText(json)

    val obj = Json.decodeFromString<Department>(json)
    println(obj)

}

@Serializable
data class Employee (val name: String, val age: Int)

@Serializable
data class Department(var name: String, var leader: Employee)

