package org.example.day18.util

import java.io.File
import java.util.Properties

object Config {
    val apiKey: String by lazy {
        val properties = Properties()
        val localPropertiesFile = File("local.properties")
        if (localPropertiesFile.exists()) {
            properties.load(localPropertiesFile.inputStream())
            properties.getProperty("API_KEY") ?: throw IllegalStateException("API_KEY not found in local.properties")
        } else {
            throw IllegalStateException("local.properties file not found")
        }
    }
}