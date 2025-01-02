package org.hyunjung.day11

import java.io.File
import java.io.IOException
import java.nio.file.Files
import java.nio.file.StandardCopyOption

class DefaultFileOperations : FileOperations {
    var errorLog: String? = null

    override fun copy(sourcePath: String, targetPath: String) {
        try {
            val sourceFile = File(sourcePath)
            val targetFile = File(targetPath)

            if (!sourceFile.exists()) {
                throw IOException("Source file does not exist: \"$sourcePath\"")
            }

            targetFile.parentFile?.let { dir ->
                if (!dir.exists()) {
                    dir.mkdirs()
                }
            }

            Files.copy(sourceFile.toPath(), targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING)
            println("File copied successfully from \"$sourcePath\" to \"$targetPath\"")
        } catch (e: Exception) {
            errorLog = "Error copying file: ${e.message}"
            println(errorLog)
        }
    }
}

fun main() {
    val fileOperations = DefaultFileOperations()
    fileOperations.copy("src/main/kotlin/day11/file.txt", "src/main/kotlin/day11/copied/file.txt")
}