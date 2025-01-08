package org.example.day16

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val httpClient = HttpClient()
    val response = httpClient.get("https://jsonplaceholder.typicode.com/phots/1")
    println(response.bodyAsText())
}

object HttpClientFactoryExam {
    fun create(): HttpClient = HttpClient(CIO)
}
