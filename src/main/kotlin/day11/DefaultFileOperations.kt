package org.example.day11

import FileOperations
import java.io.File
import java.io.FileNotFoundException

class DefaultFileOperations : FileOperations {
    override fun copy(sourcePath: String, targetPath: String) {
        try {
            val originalFile = File(sourcePath)
            val copyFile = File(targetPath)
            copyFile.writeText(originalFile.readText())

        } catch (e: FileNotFoundException) {
            println("원본 파일을 찾을 수 없습니다.")
        }
    }
}

fun main() {
    val file = DefaultFileOperations()
    file.copy("save.txt", "save_copy.txt")
}