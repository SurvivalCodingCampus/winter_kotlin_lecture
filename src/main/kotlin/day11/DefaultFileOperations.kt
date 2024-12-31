package day11

import java.io.File
import java.io.FileNotFoundException

interface FileOperations {
    fun copy(sourcePath: String, targetPath: String)
}

class DefaultFileOperations: FileOperations {
    override fun copy(sourcePath: String, targetPath: String) {

        val fileFrom: File = File(sourcePath)
        val fileTo: File = File(targetPath)

        try {
            fileTo.writeText(fileFrom.readText())
        } catch(e: FileNotFoundException) {
            println("파일을 찾을 수 없습니다.")
            throw e
        }
    }
}

// 테스트 코드 작성 전 테스트 코드
fun main() {
    val fileCreate = File("hello world.txt")
    fileCreate.writeText("Hello world!")

    var fileCopy = DefaultFileOperations()

    fileCopy.copy("hello world.txt", "copy file.txt")
}