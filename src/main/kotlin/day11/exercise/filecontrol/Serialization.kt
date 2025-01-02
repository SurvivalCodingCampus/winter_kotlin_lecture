package day11.exercise.filecontrol

import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.Writer

/*
* 연습문제
*
* 다음과 같은 사원 클래스와 부서 클래스가 있습니다.
*
* 총무부 리더 '홍길동(41세)'의 인스턴스를 생성하고 JSON으로 직렬화하여 company.txt 파일에 저장하는 프로그램을 작성하시오
* 직렬화를 위해 위의 2개 클래스를 일부 수정해도 됩니다.
* */

@Serializable
data class Employee(var name: String, var age: Int)

@Serializable
data class Department(var name: String, var leader: Employee)


fun main() {
    // 직렬화
    val json = Json.encodeToString(Department(name = "총무부", leader = Employee(name = "홍길동", age = 41)))
    println(json)

//    // 역직렬화
//    val obj = Json.decodeFromString<Department>(json)
//    println(obj)

    val file = File("company.txt")
    val bufferedWriter = BufferedWriter(FileWriter(file))
    bufferedWriter.write(json)
    bufferedWriter.close()

    val content = file.readText()
    println(content)
}
