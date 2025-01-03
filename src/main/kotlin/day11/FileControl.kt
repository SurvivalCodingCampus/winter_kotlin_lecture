package day11

import java.io.File


/*
* 파일 조작
* */
fun main() {
    // 파일 지정
    val file = File("save.txt")

    val testFile = File("load.txt")

    // 내용 쓰기
    file.writeText("Hello, World")

    // 내용 읽기
    val text = file.readText()
    println(text)


    val result = runCatching { testFile.readText() }
        .onSuccess { value -> println("읽기 성공 $value") }
        .onFailure { exception -> println("변환 실패: $exception") }


    "test".let {
        println(it)
    }

    println(result)
}