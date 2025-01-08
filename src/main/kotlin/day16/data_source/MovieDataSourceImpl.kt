import org.example.day16.utils.HttpClientFactory
import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.client.statement.*

class MovieDataSourceImpl(
    private val client: HttpClient = HttpClientFactory.create()
) : MovieRepository {
    override suspend fun getMovieInfoList(): List<Movie> {
        val response = client.get(url)
        return parseMovieResults(response.bodyAsText())
    }
}
