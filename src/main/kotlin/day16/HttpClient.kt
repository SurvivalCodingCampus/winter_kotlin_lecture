package org.example.day16


import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.coroutines.runBlocking

object HttpClientFactory{
    fun create(): HttpClient = HttpClient(CIO)
}
fun main() = runBlocking{
    val httpClient = HttpClientFactory.create()
    val response = httpClient.request("https://ktor.io/") {
        method = HttpMethod.Get
    }
    println(response.request.content)
}
