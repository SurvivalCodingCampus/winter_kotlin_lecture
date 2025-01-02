package day11.exercise.filecontrol

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.Test
import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import kotlin.test.assertEquals

class DepartmentTest {
    @Test
    fun `JSON으로 직렬화하여 company 파일에 저장 테스트`() {
        val json = Json.encodeToString(Department(name = "총무부", leader = Employee(name = "홍길동", age = 41)))
        println(json)

        val file = File("company.txt")
        val bufferedWriter = BufferedWriter(FileWriter(file))
        bufferedWriter.write(json)
        bufferedWriter.close()

        val content = file.readText()

        assertEquals(json, content)
    }

}