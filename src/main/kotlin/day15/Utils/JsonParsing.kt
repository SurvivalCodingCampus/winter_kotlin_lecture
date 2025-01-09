package org.example.day15.Utils

import kotlinx.serialization.json.Json
import java.io.File

val format = Json {
    ignoreUnknownKeys = true
    coerceInputValues = true
    prettyPrint = true
    isLenient = true
}


fun readJson(targetPath: String): String {
    val file = File(targetPath)
    if (!file.exists()) {
        throw IllegalArgumentException("File not found at path: $targetPath")
    }

    return file.readText()
}

inline fun <reified T> parseJson(json: String): List<T> {
    return format.decodeFromString<List<T>>(json)
}
