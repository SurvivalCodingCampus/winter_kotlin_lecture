package com.survivalcoding.com.survivalcoding.day11

import java.io.File

fun main() {
    val file = File("save.txt")

    file.writeText("Hello World")
//    file.appendText("\nHello World")

//    try {
    val file2 = File("load.txt")
    println(file2.readText())
//    } catch (e: FileNotFoundException) {
//        println("파일이 없습니다")
//    }
}