package day13

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import java.io.File

fun main() = runBlocking {
    val content = "Hello, World!"
    saveFile(content)
    println("File saved!!")
}

suspend fun saveFile(content: String) {
    withContext(Dispatchers.IO) {
        // 파일 저장
        File("output.txt").writeText(content)
    }
}