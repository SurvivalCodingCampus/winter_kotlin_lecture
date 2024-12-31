package day11

import org.example.day11.DefaultFileOperations
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.io.File
import java.io.FileNotFoundException
import java.io.IOException

class DefaultFileOperationsTest {
    private val sourcePath = "test_source.txt"
    private val targetPath = "test_target.txt"
    private lateinit var fileOperations: DefaultFileOperations

    @Before
    fun setUp() {
        fileOperations = DefaultFileOperations()
        File(sourcePath).writeText("테스트용 파일!")
    }

    @After
    fun tearDown() {
        File(sourcePath).delete()
        File(targetPath).delete()
    }

    @Test
    fun `copy 메서드가 정상적으로 파일을 복사해야 함`() {
        fileOperations.copy(sourcePath, targetPath)

        val sourceFile = File(sourcePath)
        val targetFile = File(targetPath)

        assertTrue(targetFile.exists()) // 파일체크
        assertEquals(sourceFile.readText(), targetFile.readText()) // 내용 비교
    }
}