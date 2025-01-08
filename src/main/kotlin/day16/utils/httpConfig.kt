package org.example.day16.utils

import io.ktor.client.*
import io.ktor.client.engine.cio.*


object HttpClientFactory {
    fun create(): HttpClient {
        return HttpClient(CIO)
    }
}


