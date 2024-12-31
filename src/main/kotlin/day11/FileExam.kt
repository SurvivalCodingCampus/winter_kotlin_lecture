package org.example.day11

import java.io.File

fun main() {
    val file = File("test.txt")

    file.writeText("Hello, World!")
    /// writeText의 경우 덥어 씌워짐
    file.writeText("Hello, World!\n")
    /// appendText의 경우 이어 씌워짐
    file.appendText("Hello, World!2")

    println(file.readText())

    try {
        val file2 = File("test2.txt")
        /// Exception in thread "main" java.io.FileNotFoundException: test2.txt (No such file or directory)
        println(file2.readText())
    } catch (e: Exception) {
        println("파일이 없습니다.")
    }
}