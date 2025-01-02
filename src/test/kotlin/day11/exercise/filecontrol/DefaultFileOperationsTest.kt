package day11.exercise.filecontrol

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

import java.io.File

class DefaultFileOperationsTest {

    @Test
    fun `파일 복사 테스트`() {

        // 파일 복사 진행
        val topPath = System.getProperty("user.dir")
        val targetPath = "$topPath/src/main/kotlin/day11/exercise"
        val sourcePath = "/Users/kjy/winter_kotlin_study/save.txt"
        val fileOperator = DefaultFileOperations()
        fileOperator.copy(sourcePath, targetPath, "tts", "tts")


        // 내용이 같은지 테스트
        val originContent = File("/Users/kjy/winter_kotlin_study/save.txt").readText()
        val copyContent = File("src/main/kotlin/day11/exercise/tts/tts.txt").readText()

        assertEquals(originContent, copyContent)
    }
}