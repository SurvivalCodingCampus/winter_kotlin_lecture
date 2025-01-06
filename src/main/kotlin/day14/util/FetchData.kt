package org.example.day14.util

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

suspend inline fun <reified T> fetchData(url: String): T {
    val httpUrlConnection = withContext(Dispatchers.IO) {
        URL(url).openConnection() as HttpURLConnection
    }

    val data = try {
        httpUrlConnection.requestMethod = "GET"
        httpUrlConnection.inputStream.bufferedReader().use { it.readText() }
    } finally {
        httpUrlConnection.disconnect()
    }

    return jsonConfig.decodeFromString(data)
}