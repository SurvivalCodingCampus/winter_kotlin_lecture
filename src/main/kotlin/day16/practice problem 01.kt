package day16

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.SerialName
import kotlinx.serialization.json.Json
import kotlinx.serialization.Serializable

@Serializable
data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    @SerialName("release_date") val releaseDate: String,
)

interface MovieDataSource {
    suspend fun getUpcomingMovies(): List<Movie>
}

interface MovieRepository {
    suspend fun getMovieInfoList(): List<Movie>
}

class MockMovieDataSourceImpl: MovieDataSource {
    val data = """
        {
            "id": 939243,
            "title": "수퍼 소닉 3",
            "overview": "너클즈, 테일즈와 함께 평화로운 일상을 보내던 초특급 히어로 소닉...",
            "release_date": "2024-12-19"
        }
    """.trimIndent()

    override suspend fun getUpcomingMovies(): List<Movie> {
        return Json.decodeFromString<List<Movie>>(data)
    }
}

class MovieDataSourceImpl: MovieDataSource {
    override suspend fun getUpcomingMovies(): List<Movie> {
        val client = HttpClient {
            HttpClient(CIO)
        }
        val url = "https://api.themoviedb.org/3/movie/upcoming?api_key=a64533e7ece6c72731da47c9c8bc691f&language=ko-KR&page="
        // url에서 upcomming 이후로는 따로 append 식으로 붙여주는 식으로 해준다.
        val totalPage = 45

        var stringData = client.get(url).bodyAsText()
        stringData = "[" + stringData.substringAfter('[', stringData).substringBeforeLast("total_pages").substringBeforeLast(',')

        val json = Json { ignoreUnknownKeys = true }

        return json.decodeFromString<List<Movie>>(stringData)

    }
}

class MovieRepositoryImpl(private val dataSource: MovieDataSource): MovieRepository {
    override suspend fun getMovieInfoList(): List<Movie> {
        return dataSource.getUpcomingMovies()
    }
}


fun main() = runBlocking {
    var url = "https://api.themoviedb.org/3/movie/upcoming?api_key=a64533e7ece6c72731da47c9c8bc691f&language=ko-KR&page="

//    for(i in 1..5) {
//        println(url + "$i")
//    }
    url += 1
    println(url)

    val client = HttpClient { HttpClient() }
    //val data = Json.decodeFromString<List<Movie>>(client.get(url).bodyAsText())
    var stringData = client.get(url).bodyAsText()
    stringData = "[" + stringData.substringAfter('[', stringData).substringBeforeLast("total_pages").substringBeforeLast(',')
    //println(stringData)

    val json = Json { ignoreUnknownKeys = true }
    //println(stringData)
    val data = json.decodeFromString<List<Movie>>(stringData)
    println(data)
}