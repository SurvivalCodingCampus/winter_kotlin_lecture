package day11

import org.example.day11.DefaultFileOperations
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.PrintStream


class DefaultFileOperationsTest {
    private val defaultFileOperations = DefaultFileOperations()
    private val sourcePaths = mutableListOf("origin1.txt", "origin2.txt", "origin3.txt")
    private val targetPaths = mutableListOf("copy1.txt", "copy2.txt", "copy3.txt")

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun `DefaultFileOperations 경로 정상 복사 테스트`() {

        for (i in 0..<sourcePaths.size) {
            val sourceFlie = File(sourcePaths[i])
            val targetFile = File(targetPaths[i])

            // 테스트용 텍스트 작성
            sourceFlie.writeText("${i}번째 테스트")

            // 복사
            defaultFileOperations.copy(sourcePaths[i], targetPaths[i])

            assertEquals("${i}번째 테스트", sourceFlie.readText())
            assertEquals("${i}번째 테스트", targetFile.readText())

            sourceFlie.delete()
            targetFile.delete()
        }
    }

    @Test
    fun `경로가 이상한 경우`() {
        // 경로가 이상한 경우 경로 이상 문구 출력
        // 케이스 1
        var outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        // 복사
        defaultFileOperations.copy("", "")

        var exceptionText: String = outputStream.toString().trim()

        System.setOut(System.out)

        assertEquals("파일을 찾을 수 없습니다", exceptionText.trim())

        // 케이스 2
        outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        // 복사
        defaultFileOperations.copy("origin4.txt", "")

        exceptionText = outputStream.toString().trim()

        System.setOut(System.out)

        assertEquals("파일을 찾을 수 없습니다", exceptionText.trim())

        // 케이스 3
        outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        // 복사
        defaultFileOperations.copy("", "copy4.txt")

        exceptionText = outputStream.toString().trim()

        System.setOut(System.out)

        assertEquals("파일을 찾을 수 없습니다", exceptionText.trim())

        // 케이스 4
        outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        // 복사
        defaultFileOperations.copy("ㅁㄴㅇㄻㄴㄹ", "ㅁㅁㅁㅁㅁㅁㄹㅇㄴㄻㄴ")

        exceptionText = outputStream.toString().trim()

        System.setOut(System.out)

        assertEquals("파일을 찾을 수 없습니다", exceptionText.trim())
    }

}