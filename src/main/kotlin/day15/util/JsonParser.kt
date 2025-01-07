package org.hyunjung.day15.util

import kotlinx.serialization.json.Json

object JsonParser {

    inline fun <reified T> parseJson(json: String): T {
        return Json.decodeFromString(json)
    }
}