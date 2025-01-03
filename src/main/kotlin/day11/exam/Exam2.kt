package org.example.day11.exam

import java.io.File

interface FileOperations {
    fun copy(sourcePath: String, targetPath: String)
}

class DefaultFileOperations : FileOperations {
    override fun copy(sourcePath: String, targetPath: String) {
        val sourceFile = File(sourcePath)
        val targetFile = File(targetPath)

        targetFile.writeBytes(sourceFile.readBytes())
    }
}

fun main() {
    val fileOperations = DefaultFileOperations()
    fileOperations.copy("source.txt", "target.txt")

    val name: String? = null

//    if (name != null) {
//        println(name.uppercase())
//    }

    name?.let {
        println(it.uppercase())
    }
}