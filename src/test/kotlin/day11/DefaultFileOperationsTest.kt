package day11

import org.junit.Test

import org.junit.Assert.*
import java.io.File
import java.io.FileNotFoundException

class DefaultFileOperationsTest {
    val fileCreate = File("hello world.txt")

    @org.junit.After
    fun tearDown() {
        fileCreate.delete()
        File("copy file.txt").delete()
    }

    @Test
    fun copy() {
        // 정상적인 파일 복사 확인

        fileCreate.writeText("Hello world!")

        val fileCopy = DefaultFileOperations()

        fileCopy.copy("hello world.txt", "copy file.txt")

        // 원본과 복사본의 내용 비교가 이루어진다.
        assertEquals(File("hello world.txt").readText(), File("copy file.txt").readText())


        // 복사하고자하는 원본 파일이 없는 경우 예외 처리 확인
        org.junit.jupiter.api.assertThrows<FileNotFoundException> {
            fileCopy.copy("what are you doing.txt", "copy file.txt")
        }
    }


}