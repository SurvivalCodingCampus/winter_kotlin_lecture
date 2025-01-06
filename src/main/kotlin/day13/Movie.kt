package org.example.day13

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Movie(
    val title: String,
    val director: String,
    val year: Int
)

suspend fun getMovieInfo(): Movie {
    delay(1000)
    val json = """ {
        "title": "Star Wars", 
        "director": "George Lucas", 
        "year": 1977
        }
        """

    val data = Json.decodeFromString<Movie>(json)
    return data
}

fun main() = runBlocking {
    println(getMovieInfo().director)
}