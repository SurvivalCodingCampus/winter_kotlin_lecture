package org.example.day11

import java.io.File

fun main() {
    val file = File("save.txt")
    file.writeText("Hello World")
    file.appendText("Hello World")

    val file2 = File("load.txt")
    val text = file2.readText()
    // 파일이 없어서 예러

    println(text)
}