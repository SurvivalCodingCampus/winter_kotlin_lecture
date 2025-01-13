package org.hyunjung.day18.util

import java.io.File
import java.util.*

object Constants {
    val API_KEY = getApiKey()
}

private fun getApiKey(): String {
    val properties = Properties()
    val file = File("apikey.properties")
    if (!file.exists()) {
        throw IllegalStateException("API Key file not found!")
    }
    properties.load(file.inputStream())
    return properties.getProperty("PIXABAY_API_KEY")
        ?: throw IllegalStateException("API Key is not set!")
}