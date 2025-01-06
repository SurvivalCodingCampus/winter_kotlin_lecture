package day13

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

@Serializable
data class Movie(val title: String, val director: String, val year: Int)

suspend fun getMovieInfo(): Movie {
    delay(1000)
    val json = """{"title": "Star Wars", "director": "George Lucas", "year": 1977}"""

    // TODO : Movie 데이터를 리턴하도록 작성
    val movie = Json.decodeFromString<Movie>(json)
    return movie
}

//fun main() = runBlocking {
//    val movie = getMovieInfo()
//    println("title: ${movie.title}")
//    println("director: ${movie.director}")
//    println("year: ${movie.year}")
//}