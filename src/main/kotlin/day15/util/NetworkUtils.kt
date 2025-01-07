package org.hyunjung.day15.util

import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

object NetworkUtils {

    fun createHttpConnection(url: String, requestMethod: String = "GET"): HttpURLConnection {
        val connection = URL(url).openConnection() as HttpURLConnection
        connection.apply {
            connectTimeout = Constants.TIMEOUT
            readTimeout = Constants.TIMEOUT
            this.requestMethod = requestMethod
            setRequestProperty("Content-Type", "application/json")
        }
        return connection
    }

    fun readStream(inputStream: InputStream): String {
        return BufferedReader(InputStreamReader(inputStream)).use { reader ->
            reader.readText()
        }
    }

    fun handleHttpError(responseCode: Int): String {
        return when (responseCode) {
            HttpURLConnection.HTTP_BAD_REQUEST -> "Bad Request (400)"
            HttpURLConnection.HTTP_UNAUTHORIZED -> "Unauthorized (401)"
            HttpURLConnection.HTTP_FORBIDDEN -> "Forbidden (403)"
            HttpURLConnection.HTTP_NOT_FOUND -> "Not Found (404)"
            HttpURLConnection.HTTP_INTERNAL_ERROR -> "Internal Server Error (500)"
            else -> "Unknown Error ($responseCode)"
        }
    }
}