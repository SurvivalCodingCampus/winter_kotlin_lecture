package org.example.day11

import java.io.File
import java.io.FileNotFoundException

fun main() {
    val file = File("save.txt")

    file.writeText("Hello World") // set 이라 덮어 씌움
//    file.appendText("\nHello World")


    try {
        val file2 = File("load.txt")
        println(file2.readText())
    } catch (e: FileNotFoundException) {
        println("파일이 없습니다")
    }

}