package day16.data

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

object Data {
    @OptIn(ExperimentalSerializationApi::class)
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json(Json { allowTrailingComma })
        }
        install(Logging)
    }
}