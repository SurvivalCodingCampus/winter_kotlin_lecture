package day18.util

import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

fun createMockEngine(responseHandler: MockRequestHandler): HttpClient {
    return HttpClient(MockEngine) {
        engine {
            addHandler(responseHandler)
        }
        install(ContentNegotiation) {
            json(Json {
                ignoreUnknownKeys = true
                prettyPrint = true
            })
        }
    }
}
