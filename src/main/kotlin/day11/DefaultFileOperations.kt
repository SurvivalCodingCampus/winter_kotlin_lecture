package org.example.day11

import java.io.File
import java.io.FileNotFoundException

class DefaultFileOperations : FileOperations {

    override fun copy(sourcePath: String, targetPath: String) {

        try {
            val sourceFile = File(sourcePath)
            val targetFile = File(targetPath)
            val copyText = sourceFile.readText()

            targetFile.writeText(copyText)
        } catch (e: FileNotFoundException) {
            println("파일을 찾을 수 없습니다")
        } catch (e: Exception) {
            println(Exception())
        }
    }
}