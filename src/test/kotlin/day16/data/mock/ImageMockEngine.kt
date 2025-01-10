package day16.data.mock

import UrlWithContentTestData
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*

val imageMockEngine = MockEngine { request ->
    when (request.url.toString()) {
        imgUrlTests[0].url -> {
            respond(
                content = ByteReadChannel(imgUrlTests[0].content),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "image/png")
            )
        }

        imgUrlTests[1].url -> {
            respond(
                content = ByteReadChannel(imgUrlTests[1].content),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "image/png")
            )
        }

        else -> {
            respondError(HttpStatusCode.NotFound)
        }
    }
}

val imgUrlTests = listOf(
    "https://test.com/image1.png" to byteArrayOf(1, 2, 3),
    "https://test.com/image2.png" to byteArrayOf(3, 4, 5),
    "https://test.com/image3.png" to byteArrayOf(6, 7, 8),
).map { UrlWithContentTestData(it.first, it.second) }
