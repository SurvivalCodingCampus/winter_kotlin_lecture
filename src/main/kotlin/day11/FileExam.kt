package org.example.day11

import java.io.File
import java.io.FileNotFoundException

fun main() {
    val file = File("save.txt")
    val file2 = file
    //file.writeText("Hello World\n") // 쓰기
    //file.appendText("hi") // 이어 붙이기

    file2.appendText("\nhihihi")
    println(file2.readText()) // 읽기
    //file.delete() // 삭제
    println(file2.readText()) // 읽기

    try {
        val file2 = File("load.text")
        println(file2.readText())
    } catch (e: FileNotFoundException) {
        println("파일이 없습니다.")
    }

}