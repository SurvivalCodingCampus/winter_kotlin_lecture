package day13.exercise

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.Json

/*
* API 호출 및 데이터 처리
*
* 영화 정보 반환
* Movie 클래스를 작성,
* 위 함수를 완성하고 director가 누군지 출력하는 main 함수 작성.
* */


fun main() = runBlocking {
    val movieDirector = getMovieInfo().director
    println(movieDirector)
}

suspend fun getMovieInfo(): Movie {
    delay(1000L)
    val json = """
        {
        "title": "Star Wars",
        "director": "George Lucas",
        "year" : 1977
        }
    """.trimIndent()

    val result = Json.decodeFromString<Movie>(json)
    return result
}


