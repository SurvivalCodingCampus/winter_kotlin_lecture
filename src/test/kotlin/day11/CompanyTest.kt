package day11

import kotlinx.serialization.json.Json
import org.example.day11.Company
import org.example.day11.Department
import org.example.day11.Employee
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class CompanyTest {
    val departmentName = "총무부"
    val employeeName = "홍길동"
    val employeeAge = 41

    @After
    fun tearDown() {
        Company.clearData()
    }

    @Test
    fun saveDepartmentData() {
        val department = Department(departmentName, Employee(employeeName, employeeAge))
        Company.saveDepartmentData(department)

        assertTrue("파일이 생성 되어야 한다.", Company.file.exists())
        assertTrue("파일의 이름은 ${Company.FILE_NAME} 이어야 한다.", Company.file.name == Company.FILE_NAME)

        val savedDepartment = Company.file.readText()

        Json.decodeFromString(Department.serializer(), savedDepartment).let {
            assertEquals("부서 이름은 $departmentName 이어야 한다.", departmentName, it.name)
            assertEquals("직원 이름은 $employeeName 이어야 한다.", employeeName, it.leader.name)
            assertEquals("직원 나이는 $employeeAge 이어야 한다.", employeeAge, it.leader.age)
        }

    }

}