package day11

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.io.File
import java.io.FileNotFoundException

class DefaultFileOperationsTest {
    private val testPath = "test.txt"
    private val testText = "test\ntest\ntest"
    private lateinit var testFile: File

    @Before
    fun createTempFile() {
        testFile = File(testPath)
        testFile.writeText(testText)
    }

    @Test
    fun `test copy`() {
        val fileManager = DefaultFileOperations()
        Assert.assertThrows(FileNotFoundException::class.java) {
            fileManager.copy("", testPath)
        }
        Assert.assertThrows(IllegalArgumentException::class.java) {
            fileManager.copy(testPath, "")
        }
    }

    @After
    fun tearDown() {
        testFile.delete()
    }
}