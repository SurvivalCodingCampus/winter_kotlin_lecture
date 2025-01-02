package day11

import java.io.File
import java.util.regex.Pattern

class DefaultFileOperations : FileOperations {
    override fun copy(sourcePath: String, targetPath: String) {
        // 대상 경로 유효성 검사
        val regex = "^[a-zA-Z0-9._-]+\\.[a-zA-Z]+\$"
        if (!Pattern.matches(regex, targetPath)) {
            throw IllegalArgumentException("대상 경로가 유효하지 않습니다")
        }

        try {
            // 파일 복사
            val file = File(sourcePath)
            val content = file.readText()
            val newFile = File(targetPath)
            newFile.writeText(content)

            println("파일이 복사되었습니다.")
        } catch (e: Exception) {
            println("파일 복사 중 오류가 발생했습니다: ${e.message}")
        }
    }

}

