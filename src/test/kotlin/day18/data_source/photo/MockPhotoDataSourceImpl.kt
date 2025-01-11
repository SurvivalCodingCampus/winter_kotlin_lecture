package day18.data_source.photo

import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.io.IOException
import kotlinx.serialization.json.Json
import org.example.day18.data_source.photo.PhotoDataSource
import org.example.day18.dto.photo.PhotoDto
import org.example.day18.dto.photo.PhotoResult


class MockPhotoDataSourceImpl : PhotoDataSource {
    private val mockEngine = MockEngine { request ->
        when (request.url.toString()) {
            "https://pixabay.com/api/?key=7777&q=cutedog" -> respond(
                content = """
                {
            "total": 2,
            "totalHits": 2,
            "hits": [
            {
               "id": 4643706,
               "pageURL": "https://pixabay.com/photos/puppy-dog-animal-cute-pet-dog-pet-4643706/",
               "type": "photo",
               "tags": "puppy, dog, animal",
               "previewURL": "https://cdn.pixabay.com/photo/2019/11/21/22/44/puppy-4643706_150.jpg",
               "previewWidth": 150,
               "previewHeight": 100,
               "webformatURL": "https://pixabay.com/get/gd2c4c0f3c1699ef4713eea4e1217100f89d67bdfe15f876c1ba099c3ba627ae0258459c0b3c461c3f34a08498bbaf2aab08c5732603654ed2c266ae4e94f67d0_640.jpg",
               "webformatWidth": 640,
               "webformatHeight": 427,
               "largeImageURL": "https://pixabay.com/get/g63aa315fffd882238e93d1dc16c71d280cf6b77b9a5a4c4681f7a3ca6f82879363e1423ccac2ba69958dc037865b7dd588bf770c549e9eb68df17800db818f33_1280.jpg",
               "imageWidth": 3150,
               "imageHeight": 2106,
               "imageSize": 1045008,
               "views": 12209,
               "downloads": 11265,
               "collections": 122,
               "likes": 8,
               "comments": 0,
               "user_id": 10021952,
               "user": "Darong_family",
               "userImageURL": "https://cdn.pixabay.com/user/2019/11/01/13-46-30-947_250x250.jpg"
             },
             {
               "id": 4616497,
               "pageURL": "https://pixabay.com/photos/puppy-dog-animal-cute-white-small-4616497/",
               "type": "photo",
               "tags": "puppy, dog, animal",
               "previewURL": "https://cdn.pixabay.com/photo/2019/11/10/18/31/puppy-4616497_150.jpg",
               "previewWidth": 150,
               "previewHeight": 99,
               "webformatURL": "https://pixabay.com/get/g41bdb221d025ae9ac4e5af769972f34f802afaa706d3cabf419b032d735c4ae338c25e1a80bc2851fcf523746cbebbebf554f1164da101d6f28e2482fa43f0d7_640.jpg",
               "webformatWidth": 640,
               "webformatHeight": 424,
               "largeImageURL": "https://pixabay.com/get/gdb92c1856f408ad1fc5c69d60c9ae1ef9ed898abd9d3bab9662193ba6447bee1d7d7389af9d411c57e2c4126e745927fe0415247d38b37c6a72592f2311a9875_1280.jpg",
               "imageWidth": 5280,
               "imageHeight": 3503,
               "imageSize": 3579166,
               "views": 9376,
               "downloads": 9022,
               "collections": 44,
               "likes": 6,
               "comments": 0,
               "user_id": 10021952,
               "user": "Darong_family",
               "userImageURL": "https://cdn.pixabay.com/user/2019/11/01/13-46-30-947_250x250.jpg"
             }
           ]
         }
            """.trimIndent(),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )

            "https://pixabay.com/api/?key=7777&q=network+error" -> respond(
                content = """
                    [Error 400] Bad Request
                """.trimIndent(),
                status = HttpStatusCode.BadRequest,
                headers = headersOf(HttpHeaders.ContentType, "text/palin")
            )

            "https://pixabay.com/api/?key=7777&q=" -> respond(
                content = """""".trimIndent(),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )

            else -> respond(
                content = """
                    [Error 500] InternalServerError
                """.trimIndent(),
                status = HttpStatusCode.InternalServerError,
                headers = headersOf(HttpHeaders.ContentType, "text/palin")
            )
        }
    }
    private val client: HttpClient = HttpClient(mockEngine)
    private val url = "https://pixabay.com/api/?key=7777&q="

    override suspend fun getPhotos(query: String): List<PhotoDto> {
        val response = client.get("$url$query")

        if(response.status == HttpStatusCode.BadRequest) throw IOException("네트워크 에러")
        if(response.status == HttpStatusCode.InternalServerError) throw ClientRequestException(response, "서버 에러")

        val data = Json.decodeFromString<PhotoResult>(response.bodyAsText()).hits

        return data ?: emptyList()
    }
}