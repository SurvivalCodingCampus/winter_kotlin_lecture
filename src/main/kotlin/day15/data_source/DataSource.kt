package org.example.day15.data_source

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

interface DataSource {
    @OptIn(ExperimentalSerializationApi::class)
    val defaultJson
        get() = Json {
            ignoreUnknownKeys = true
            allowTrailingComma = true
            encodeDefaults = true
        }
}