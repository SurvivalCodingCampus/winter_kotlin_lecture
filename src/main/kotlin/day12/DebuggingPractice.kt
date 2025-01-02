package org.example.day12

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.File

@OptIn(ExperimentalSerializationApi::class)
private var json = Json { allowTrailingComma = true }

fun main() {
    val file = File("debuging_practice")

    println(file.readText())

    val data = json.decodeFromString<CollectionChartDataList>(file.readText())

    println(data.toString())


    val jsonData = Json.encodeToString(data)

    println(jsonData)
}