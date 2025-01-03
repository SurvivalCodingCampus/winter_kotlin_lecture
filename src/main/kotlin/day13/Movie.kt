package org.example.day13

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Movie(
    val title: String,
    val director: String,
    val year: Int,
)

suspend fun getMovieInfo(): Movie {
    delay(1000L)
    val json = """{"title": "Star wars", "director": "George Lucas", "year": 1977}"""
    return Json.decodeFromString<Movie>(json)
}

fun main() = runBlocking {
    val deferred = async { getMovieInfo() }
    val movie = deferred.await()
    println(movie.director)
}