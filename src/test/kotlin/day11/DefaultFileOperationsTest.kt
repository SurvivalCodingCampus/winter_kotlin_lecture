package day11

import org.example.day11.DefaultFileOperations
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.jupiter.api.assertDoesNotThrow
import java.io.File
import java.io.FileNotFoundException

class DefaultFileOperationsTest {
    val sampleText = "Hello, World!"
    val unknownPath = "src/test/resources/unknown.txt"
    val illegalPath = ""
    val sourcePath = "src/test/resources/source.txt"
    val targetPath = "src/test/resources/target.txt"
    val sourceFile = File(sourcePath)
    val targetFile = File(targetPath)

    @Before
    fun setUp() {
        sourceFile.writeText(sampleText)
    }

    @After
    fun tearDown() {
        sourceFile.delete()
        targetFile.delete()
    }

    @Test
    fun copy() {
        val fileOperations = DefaultFileOperations()

        val unknownFile = File(unknownPath)
        val sourceFile = File(sourcePath)
        val targetFile = File(targetPath)

        assertFalse("unknownFile은 존재 하지 않아야 한다.", unknownFile.exists())
        assertTrue("sourceFile은 존재 해야 한다.", sourceFile.exists())
        assertFalse("copy 실행 전 targetFile이 존재 해선 안된다.", targetFile.exists())

        assertDoesNotThrow("예외가 발생하지 않아야 한다.") {
            fileOperations.copy(sourcePath, targetPath)
        }

        assertTrue("copy 실행 후 targetFile이 존재 해야 한다.", targetFile.exists())
        assertEquals("sourceFile과 targetFile의 내용이 같아야 한다.", sourceFile.readText(), targetFile.readText())

        assertThrows<FileNotFoundException>("FileNotFoundException이 발생해야 한다.", FileNotFoundException::class.java) {
            fileOperations.copy(unknownPath, targetPath)
        }

        assertThrows<IllegalArgumentException>(
            "IllegalArgumentException이 발생해야 한다.",
            IllegalArgumentException::class.java
        ) {
            fileOperations.copy(sourcePath, illegalPath)
        }
    }
}