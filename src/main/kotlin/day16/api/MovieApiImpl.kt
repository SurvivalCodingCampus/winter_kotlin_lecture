package day16.api

import day16.model.MovieResponse
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.serialization.json.Json

class MovieApiImpl(private val client: HttpClient) {
    // Json 인스턴스를 전역적으로 한번만 생성
    private val json = Json { ignoreUnknownKeys = true }    // 응답에 예상치 못한 키가 있어도 예외를 발생시키지 않도록 설정
    private val baseUrl = "https://api.themoviedb.org/3/movie/upcoming" // TMDB API의 기본 URL. 영화 목록을 가져오는 엔드포인트
    private val apiKey = "a64533e7ece6c72731da47c9c8bc691f"     // API 호출 시 api_key 파라미터로 전달되어 인증을 수행
    private val language = "ko-KR"
    private val page = 1

    suspend fun fetchUpcomingMovies(): MovieResponse {         //  HTTP GET 요청을 TMDB API에 보내고, 영화 목록 데이터를 가져온다
        val response: HttpResponse = client.get(baseUrl) {  // HTTP 요청을 보내고, 파라미터를 함께 전달
            parameter("api_key", apiKey)
            parameter("language", language)
            parameter("page", page)
        }
        val responseBody = response.bodyAsText()        // API에서 받은 응답을 response.bodyAsText()로 읽는다

        // 한번 생성된 json 인스턴스 사용
        return json.decodeFromString<MovieResponse>(responseBody)   // json 문자열을 MovieResponse 객체로 변환
    }
}
