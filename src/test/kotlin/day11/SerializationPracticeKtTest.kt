package day11

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.day11.Department
import org.example.day11.Employee
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import java.io.File

class SerializationPracticeKtTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `인스턴스 생성하고 JSON으로 직렬화하여 txt 파일에 저장`() {
        val file = File("company.txt")
        val staff = Department("총무부", Employee("홍길동", 41))
        val json = Json.encodeToString(staff)

        file.writeText(json)

        val checkText = Json.decodeFromString<Department>(file.readText()).toString()

        assertEquals("{\"name\":\"총무부\",\"leader\":{\"name\":\"홍길동\",\"age\":41}}", json)
        assertEquals("Department(name=총무부, leader=Employee(name=홍길동, age=41))", checkText)

        file.delete()
    }
}