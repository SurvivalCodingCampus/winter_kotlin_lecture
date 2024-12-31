package day11

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.day11.Department
import org.example.day11.Employee
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.io.File

class SerializationTest {

    private val testFile = File("test_company.txt")
    private lateinit var department: Department

    @Before
    fun setUp() {
        val employee = Employee("홍길동", 41)
        department = Department("총무부", employee)
    }

    @After
    fun tearDown() {
        testFile.delete()
    }

    @Test
    fun `Department 객체를 JSON으로 직렬화하고 파일에 저장할 수 있어야 함`() {
        // JSON 직렬화
        val json = Json.encodeToString(department)

        // 파일에 저장
        testFile.writeText(json)

        // 파일 존재 여부 확인
        assertTrue(testFile.exists())

        // 파일 내용 확인
        val fileContent = testFile.readText()
        assertEquals(json, fileContent)
    }

    @Test
    fun `파일에서 읽은 JSON 데이터를 Department 객체로 역직렬화할 수 있어야 함`() {
        // JSON 직렬화 후 파일에 저장
        val json = Json.encodeToString(department)
        testFile.writeText(json)

        // 파일에서 읽기 및 역직렬화
        val fileContent = testFile.readText()
        val deserializedDepartment = Json.decodeFromString<Department>(fileContent)

        // 역직렬화 결과 확인
        assertEquals(department, deserializedDepartment)
    }
}