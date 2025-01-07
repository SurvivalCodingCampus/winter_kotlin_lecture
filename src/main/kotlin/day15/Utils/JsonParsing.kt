package org.example.day15.Utils

import kotlinx.serialization.json.Json
import java.io.File

val format = Json {
    ignoreUnknownKeys = true
    prettyPrint = true
    isLenient = true
}


inline fun <reified T> parseJson(targetPath: String): List<T> {
    val file = File(targetPath)
    if (!file.exists()) {
        throw IllegalArgumentException("File not found at path: $targetPath")
    }

    val readText = file.readText()
    return format.decodeFromString<List<T>>(readText)
}
