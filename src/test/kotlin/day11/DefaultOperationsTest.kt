package day11

import org.example.day11.DefaultOperations
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import java.io.File
import java.time.LocalDate

class DefaultOperationsTest {
    private val defaultOperations = DefaultOperations()
    private val date = LocalDate.now().toString().replace("-", "")
    private val sourceFilePath = "source${date}"
    private val targetFilePath = "copy${date}"

    @Before
    fun setUp() {
        deleteAllFile()
        File(sourceFilePath).writeText("원본 파일 생성[$sourceFilePath]")
    }

    @Test
    fun `copy 함수 테스트(1) target 경로에 파일이 없는 경우 새로 만듦`() {
        val sourceText = File(sourceFilePath).readText()
        defaultOperations.copy(sourceFilePath, targetFilePath)
        val copyFile = File(targetFilePath)
        assertTrue(copyFile.exists())
        assertEquals(sourceText, copyFile.readText())
    }

    @Test
    fun `copy 함수 테스트(2) target 경로에 파일이 존재하는 경우 이어 붙임`() {
        val text = "원래 파일에 있던 내용"
        val sourceText = File(sourceFilePath).readText()
        val targetFile = File(targetFilePath)
        targetFile.writeText(text)
        
        defaultOperations.copy(sourceFilePath, targetFilePath)
        assertEquals(text + sourceText, targetFile.readText())
    }

    @After
    fun tearDown() {
        deleteAllFile()
    }

    private fun deleteAllFile() {
        File(sourceFilePath).delete()
        File(targetFilePath).delete()
    }
}