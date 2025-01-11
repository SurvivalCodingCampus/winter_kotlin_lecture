package org.example.day18

import io.github.cdimascio.dotenv.dotenv

fun main() {
    val apiKey = dotenv()["PIXABAY_API_KEY"] ?: throw IllegalStateException("API Key not found")
    println("API Key: $apiKey")
}