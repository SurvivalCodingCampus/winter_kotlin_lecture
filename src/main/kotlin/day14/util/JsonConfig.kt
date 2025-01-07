package org.example.day14.util

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

@OptIn(ExperimentalSerializationApi::class)
val jsonConfig = Json {
    allowTrailingComma = true
    ignoreUnknownKeys = true
}