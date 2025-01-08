package org.example.day16

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import kotlinx.coroutines.runBlocking
import java.time.LocalDate

fun main(): Unit = runBlocking {
    val httpClient = HttpClientFactory.create()

    val response = httpClient.get("https://jsonplaceholder.typicode.com/posts/1")
    println(response.responseTime)
    println(LocalDate.now().toString() > "2025-12-19")
}

object HttpClientFactory {
    fun create(): HttpClient = HttpClient(CIO)
}