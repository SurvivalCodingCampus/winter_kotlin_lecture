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
*
* 테스트를 위해 외부에서 input을 받도록 설정
* */

val json = """
    {
    "title": "Star Wars",
    "director": "George Lucas",
    "year" : 1977
    }
""".trimIndent()

fun main() = runBlocking {
    val movieDirector = getMovieInfo(json).director
    println(movieDirector)
}


suspend fun getMovieInfo(json: String): Movie {
    delay(1000L)

    return runCatching {
        Json.decodeFromString<Movie>(json)
    }.getOrElse { exception ->      // 실패했을때 예외
        throw RuntimeException("Json 파싱 실패: ${exception.message}", exception)
    }
}


