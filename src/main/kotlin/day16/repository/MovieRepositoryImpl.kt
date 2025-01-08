import org.example.day16.utils.HttpClientFactory
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.json.decodeFromJsonElement
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import org.example.day15.Utils.format

const val url: String =
    "https://api.themoviedb.org/3/movie/upcoming?api_key=a64533e7ece6c72731da47c9c8bc691f&language=ko-KR&page=1"

fun parseMovieResults(jsonString: String): List<Movie> {
    val jsonElement = format.parseToJsonElement(jsonString)
    val resultsJson = jsonElement.jsonObject["results"]?.jsonArray
    return resultsJson?.map { format.decodeFromJsonElement<Movie>(it) } ?: emptyList()
}


fun main(): Unit = runBlocking {
//    val hello = MovieDataSourceImpl.kt().getMovieInfoList()
//    println(hello)
    val targetPath: String = "./src/main/kotlin/day16/downloads/"

    val client = HttpClientFactory.create()

    val dataSource = ImageDataSourceImpl(client)
    ImageRepositoryImpl(dataSource, targetPath).saveImageIfNotExists(imageUrl, "")
//    val result = ImageDataSourceImpl().fetchImage(imageUrl)
//    ImageDataSourceImpl().saveImage(result, targetPath)


}
