package org.example.day15.data_source

import io.ktor.client.*
import io.ktor.client.engine.cio.*

interface KtorClient : DataSource {
    val baseUrl: String

    val client: HttpClient
        get() = HttpClient(CIO)
}