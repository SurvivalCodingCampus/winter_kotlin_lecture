package day11

import org.junit.Assert.*
import org.junit.Test
import java.io.File

class DefaultFileOperationsTest {

    @Test
    fun testFileCopyWithExistingFile() {
        // 준비
        val originalFilePath = "C:\\koko\\winter_kotlin_study\\src\\main\\kotlin\\day11\\save.txt"
        val copyFilePath = "C:\\koko\\winter_kotlin_study\\src\\main\\kotlin\\day11\\saveCopy.txt"
        val originalContent = "happy new year"

        // 원본 파일 생성
        val originalFile = File(originalFilePath)
        originalFile.writeText(originalContent)

        // 동일한 이름의 파일 생성 (충돌 조건)
        val existingCopyFile = File(copyFilePath)
        existingCopyFile.writeText("Existing file content")

        // 파일 복사
        val fileOperations = DefaultFileOperations()
        fileOperations.copy(originalFilePath, copyFilePath)

        // 복사본 파일 생성 확인 (새 이름으로 생성)
        val newCopyFile = File("C:\\koko\\winter_kotlin_study\\src\\main\\kotlin\\day11\\saveCopy_copy.txt")
        assertTrue("새 이름의 복사본 파일이 생성되어야 합니다.", newCopyFile.exists())

        // 내용 비교
        val copiedContent = newCopyFile.readText()
        assertEquals("새 복사본 파일의 내용이 원본과 동일해야 합니다.", originalContent, copiedContent)

        // 테스트 완료 후 파일 삭제
//        originalFile.delete()
//        existingCopyFile.delete()
//        newCopyFile.delete()
    }
}
