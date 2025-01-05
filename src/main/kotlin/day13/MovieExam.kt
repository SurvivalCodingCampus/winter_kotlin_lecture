package day13

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

/*
연습문제1. API호출 및 데이터 처리
다음과 같은 영화 정보를 반환하는 함수가 있다.
Movie 클래스를 작성,
위 함수를 완성하고 director가 누군지 출력하는 main 함수를 작성하시오.
*/

@Serializable
data class Movie(
    val title: String,
    val director: String,
    val year: Int
)

class MovieExam {
    suspend fun getMovieInfo(): Movie {
        delay(1000)
        val json = """
            {
            "title": "Star Wars", 
            "director": "George Lucas",
            "year": 1977
            }
        """.trimIndent()
        // TODO : Movie 데이터를 리턴하도록 작성
        // Movie Json 파싱해서 받기
        val movie = Json.decodeFromString<Movie>(json)

        return movie
    }
}

fun main() = runBlocking {
    val movieExam = MovieExam()
    val movie = movieExam.getMovieInfo()
    println("Director: ${movie.director}")
}
