package day11

import java.io.File
import java.io.FileNotFoundException


fun main() {
    val sample = File("C:\\koko\\winter_kotlin_study\\src\\main\\kotlin\\day11\\test.txt")
    val text = "뿌이뿌이뿌"
    sample.writeText(text)
    val file = DefaultFileOperations()
    file.copy("C:\\koko\\winter_kotlin_study\\src\\main\\kotlin\\day11\\test.txt", "C:\\koko\\winter_kotlin_study\\src\\main\\kotlin\\day11\\testCopy.txt")
}

class DefaultFileOperations: FileOperations {
    override fun copy(sourcePath: String, targetPath: String) {
        try{
            val original = File(sourcePath)
            val copy = File(targetPath)

            val nameDuplication = if (copy.exists()) {
                val newFileName = "${copy.nameWithoutExtension}_copy.${copy.extension}"
                File(copy.parent, newFileName).absolutePath
                // nameWithoutExtension 확장자 떼고 파일명만 가져온다
                // extension 확장자를 가져온다
                // copy.parent는 대상 파일의 부모 디렉토리를 반환
                // .absoluteFile 절대경로 반환

            } else {
                targetPath
            }

            File(nameDuplication).writeText(original.readText())
            println(nameDuplication)

        } catch (e: FileNotFoundException) {
            println(e.message)
        } catch (e: Exception) {
            println(e.message)
        }
    }
}