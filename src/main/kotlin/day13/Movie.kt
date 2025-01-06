package day13
// api 호출 및 데이터처리
// Movie 클래스를 작성,
// 위 함수를 완성하고 director 가 누군지 출력하는 main 함수를 작성하시오

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

suspend fun getMovieInfo(): Movie {     //json 데이터를 가져와서 파싱
    delay(1000)
    val json = """
        {"title": "Star wars", "director": "George Lucas", "year": 1977}
    """.trimIndent()

    //todo : Movie 데이터를 리턴하도록 작성
    //json 데이터를 Movie객체로 변환하여 반환
    return Json.decodeFromString(json)
}

@Serializable   // 어노테이션 씀으로써 json데이터 파싱 가능하게 설정. (파싱이 뭐라고? json 데이터를 kotlin에서 사용할 수 있게 객체로 변환)
data class Movie(val title: String, val director: String, val year: Int)

fun main() = runBlocking{
    val movie = getMovieInfo()  // api 호출
    println("director : ${movie.director}")
}