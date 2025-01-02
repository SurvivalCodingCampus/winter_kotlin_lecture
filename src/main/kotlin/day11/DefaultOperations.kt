package org.example.day11

import java.io.File

interface FileOperations {
    fun copy(sourcePath: String, targetPath: String)
}

class DefaultOperations : FileOperations {
    override fun copy(sourcePath: String, targetPath: String) {
        File(targetPath).appendText(File(sourcePath).readText())
    }
}
