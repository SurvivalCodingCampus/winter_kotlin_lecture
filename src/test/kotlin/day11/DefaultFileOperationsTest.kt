package day11

import org.hyunjung.day11.DefaultFileOperations
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.io.File

class DefaultFileOperationsTest {

    private lateinit var fileOperations: DefaultFileOperations
    private val testSourceFile = File("src/main/kotlin/day11/test_file.txt")
    private val testTargetFile = File("src/main/kotlin/day11/copied/test_file.txt")

    @Before
    fun setUp() {
        fileOperations = DefaultFileOperations()

        testSourceFile.writeText("안녕하세요. 테스트 파일 입니다.")
    }

    @After
    fun tearDown() {
        if (testSourceFile.exists()) testSourceFile.delete()
        if (testTargetFile.exists()) testTargetFile.delete()
    }

    @Test
    fun `파일 복사 및 원본 내용과 비교`() {
        fileOperations.copy(testSourceFile.absolutePath, testTargetFile.absolutePath)
        assertTrue(testTargetFile.exists())

        val sourceContent = testSourceFile.readText()
        val targetContent = testTargetFile.readText()
        assertEquals(sourceContent, targetContent)
    }

    @Test
    fun `원본 파일이 존재하지 않을 경우 에러 메시지 출력`() {
        val nonExistentFile = File("no_file.txt")

        fileOperations.copy(nonExistentFile.absolutePath, testTargetFile.absolutePath)
        assertEquals(
            "Error copying file: Source file does not exist: \"${nonExistentFile.absolutePath}\"",
            fileOperations.errorLog
        )
    }

    @Test
    fun `복사되는 파일의 디렉토리가 존재하지 않을 경우 생성`() {
        val targetFileWithDirs = File("src/main/kotlin/day11/test-copied/test_file.txt")

        try {
            fileOperations.copy(testSourceFile.absolutePath, targetFileWithDirs.absolutePath)
            assertTrue(targetFileWithDirs.exists())

            val sourceContent = testSourceFile.readText()
            val targetContent = targetFileWithDirs.readText()
            assertEquals(sourceContent, targetContent)
        } finally {
            targetFileWithDirs.parentFile?.deleteRecursively()
        }
    }
}