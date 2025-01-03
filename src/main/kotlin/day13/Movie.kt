package org.example.day13

import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

@Serializable
data class Movie(val title: String, val director: String, val year: Int) {

    companion object {
        suspend fun getMovieInfoFromJson(json: String): Movie {
            val movie = Json.decodeFromString<Movie>(json)
            delay(1000)
            return movie
        }
    }

}
