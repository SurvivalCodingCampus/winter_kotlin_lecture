package day11.exercise.filecontrol

import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter

/*
* 연습문제
*
* 파일을 복사하는 DefaultFileOperations 클래스 작성
*
* 이 인터페이스는 파일 시스템에서 수행되는 기본적인 작업을 정의한다.
* 현재는 파일 복사 기능만 포함하고 있으며, 버퍼링이나 에러 처리는 구현하지 않는다.
* */


class DefaultFileOperations : FileOperations {
    override fun copy(sourcePath: String, targetPath: String, directoryName: String, fileName: String) {

        val dir = File(targetPath, directoryName)

        // 해당 경로에 디렉토리가 존재하지 않는다면 디렉토리 생성
        if (!dir.exists()) dir.mkdir()
        else println("해당 디렉토리가 이미 존재합니다.")


        // 원본 파일 내용 불러오기
        val sourceContent = File(sourcePath).readText()
        println(sourceContent)


        // 새로 만들 파일
        val file = File("$targetPath/$directoryName", "${fileName}.txt")

        // 파일 쓰기
        val bufferedWriter = BufferedWriter(FileWriter(file))
        bufferedWriter.write(sourceContent)
        bufferedWriter.close()

    }
}

fun main() {
    val topPath = System.getProperty("user.dir")
    val targetPath = "$topPath/src/main/kotlin/day11/exercise"
    val sourcePath = "/Users/kjy/winter_kotlin_study/save.txt"
    val fileOperator = DefaultFileOperations()
}
