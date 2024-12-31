package org.example.day11

import java.io.File
import java.io.FileNotFoundException

class DefaultFileOperations : FileOperations {
    override fun copy(sourcePath: String, targetPath: String) {
        if (sourcePath.isEmpty() || targetPath.isEmpty()) {
            throw IllegalArgumentException("파일 경로가 유효하지 않습니다.")
        }
        val sourceFile = File(sourcePath)
        val targetFile = File(targetPath)
        try {
            targetFile.writeText(sourceFile.readText())
        } catch (e: Exception) {
            when (e) {
                is FileNotFoundException -> {
                    throw FileNotFoundException("원본 파일이 존재하지 않습니다.")
                }

                else -> {
                    throw e
                }
            }
        }
    }
}