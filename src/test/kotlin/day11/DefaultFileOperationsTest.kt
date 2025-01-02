package day11

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import java.io.File

class DefaultFileOperationsTest {

    @Test
    fun `소스파일에서 타겟파일로 복사`() {
        val sourcePath = "testSource.txt"
        val targetPath = "testTarget.txt"

        val sourceFile = File(sourcePath)
        val originalContent = "Hello World"
        sourceFile.writeText(originalContent)

        val fileOperations: FileOperations = DefaultFileOperations()
        fileOperations.copy(sourcePath, targetPath)

        val targetFile = File(targetPath)
        val copiedContent = targetFile.readText()

        assertEquals(originalContent, copiedContent)

        sourceFile.delete()
        targetFile.delete()
    }

    @Test
    fun `대상 경로가 유효하지 않을 때 예외처리`() {
        val sourcePath = "testSource.txt"
        val targetPath = "incorrect///path."
        val sourceFile = File(sourcePath)
        sourceFile.writeText("Hello World")

        val fileOperations: FileOperations = DefaultFileOperations()

        val exception = assertFailsWith<IllegalArgumentException> {
            fileOperations.copy(sourcePath, targetPath)
        }
        assertEquals("대상 경로가 유효하지 않습니다", exception.message)

        sourceFile.delete()
    }

}