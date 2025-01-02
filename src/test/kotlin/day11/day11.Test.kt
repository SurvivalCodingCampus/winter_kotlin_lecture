package day11

import Department
import Employee
import FileOperation
import FileOperations
import JsonOperation
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.example.day10.KeyPad
import org.example.day10.StrongBox
import org.junit.Test
import org.junit.Assert.*
import org.junit.jupiter.api.assertAll
import java.io.File
import java.time.LocalDateTime
import java.time.LocalDateTime.*
import kotlin.test.assertFailsWith


class FileOperation {
    @Test
    fun `File operation`(): Unit = assertAll(
        "",
        {
            val base = "./src/main/kotlin/day11/"
            val sourcePath = "${base}save.txt"
            val targetPath = "./${base}save5.txt"

            FileOperation().copy(sourcePath, targetPath)

            val file = File(sourcePath)
            val copyFile = File(targetPath)

            val readText = file.readText()
            val copyText = copyFile.readText()

            assertEquals(true, readText == copyText)
        },
        {
            val base = "./src/main/kotlin/day11/"
            val sourcePath = "${base}save333.txt"
            val targetPath = "./${base}save5.txt"

            assertFailsWith<IllegalArgumentException> {
                FileOperation().copy(sourcePath, targetPath)
            }
        },
    )
}


class Seriealize {
    @Test
    fun `Serialize test`(): Unit = assertAll(
        "json result check",
        {
            val targetPath = "./src/main/kotlin/day11/save4.txt"
            val resultPath = "./src/main/kotlin/day11/company.txt"

            //clean company.txt
            File(resultPath).writeText("")
            // init instance
            val department = Department(name = "haha", leader = Employee(name = "park", age = 91))
            // encode string
            val result = Json.encodeToString(department)

            // write
            JsonOperation(department, targetPath)
            val resultFile = File(resultPath).readText()

            assertEquals(result, resultFile)
        },
    )
}
