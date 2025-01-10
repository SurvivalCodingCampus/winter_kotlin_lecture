package day18.mock

import UrlWithContentTestData
import day18.resource.testPixabayApiKey
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import kotlinx.io.IOException

val photoMockEngine = MockEngine { request ->
    when (request.url.toString()) {
        fakePhotoUrlWithContents[0].url -> {
            throw IOException()
        }

        fakePhotoUrlWithContents[1].url -> {
            respond(
                content = fakePhotoUrlWithContents[1].content,
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }

        fakePhotoUrlWithContents[2].url -> {
            respondError(HttpStatusCode.InternalServerError)
        }

        fakePhotoUrlWithContents[3].url -> {
            respond(
                content = fakePhotoUrlWithContents[3].content,
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }

        else -> {
            respondError(HttpStatusCode.NotFound)
        }
    }
}

private val testBaseUrl = "https://pixabay.com/api/?key=${testPixabayApiKey}"

private val fakePhotoUrlWithContents = listOf(
    "${testBaseUrl}&q=networkError" to "",
    "${testBaseUrl}&q=emptyQuery" to "",
    "${testBaseUrl}&q=serverError" to "",
    "${testBaseUrl}&q=success" to
            """
        {
          "total": 1944068,
          "totalHits": 500,
          "hits": [
            {
              "id": 9264474,
              "pageURL": "https://pixabay.com/illustrations/new-year-sylvester-celebration-9264474/",
              "type": "illustration",
              "tags": "new year, sylvester, celebration",
              "previewURL": "https://cdn.pixabay.com/photo/2024/12/13/08/36/new-year-9264474_150.jpg",
              "previewWidth": 150,
              "previewHeight": 96,
              "webformatURL": "https://pixabay.com/get/g13d531e90cba68c9b742c53ddd70749292a557f2346657fd4c1b6d76865edf75005a19d1aa09f9d42a7364f79d781cf2c3d9a01250789b25d0fd986278d8be4f_640.jpg",
              "webformatWidth": 640,
              "webformatHeight": 409,
              "largeImageURL": "https://pixabay.com/get/g17015e8204bf008b4472a81fbe686b56503262559474dcba95cfa7f39a1ce41df5bb34bf4fd6b761de31754a30f0b6544078a2243a82eb509c35e8c390061914_1280.jpg",
              "imageWidth": 5560,
              "imageHeight": 3552,
              "imageSize": 6373470,
              "views": 191547,
              "downloads": 48964,
              "collections": 1725,
              "likes": 127,
              "comments": 21,
              "user_id": 9301,
              "user": "geralt",
              "userImageURL": "https://cdn.pixabay.com/user/2022/08/25/06-52-36-900_250x250.jpg"
            },
            {
              "id": 3082832,
              "pageURL": "https://pixabay.com/photos/nature-waters-lake-island-3082832/",
              "type": "photo",
              "tags": "nature, free wallpaper, waters",
              "previewURL": "https://cdn.pixabay.com/photo/2018/01/14/23/12/nature-3082832_150.jpg",
              "previewWidth": 150,
              "previewHeight": 84,
              "webformatURL": "https://pixabay.com/get/g7918338f6a05d4785772331ae4f195854df8d1ed05b5266626429daac151352a87fc6b73241d534d99fa4f0691247cd9187012517e03590e60c0b4bebf6f9519_640.jpg",
              "webformatWidth": 640,
              "webformatHeight": 359,
              "largeImageURL": "https://pixabay.com/get/g2b17796ccca13dcb081aeea3c220e618f2e8e05137a4ef4f74415d4536a986dca95de46011f695645904ad257c1e54d3a94359c206d209458770260911498da9_1280.jpg",
              "imageWidth": 5757,
              "imageHeight": 3238,
              "imageSize": 4638828,
              "views": 7117198,
              "downloads": 4386362,
              "collections": 191021,
              "likes": 5228,
              "comments": 759,
              "user_id": 7645255,
              "user": "jplenio",
              "userImageURL": "https://cdn.pixabay.com/user/2024/06/10/13-43-32-848_250x250.jpg"
            },
            {
              "id": 3605547,
              "pageURL": "https://pixabay.com/photos/ocean-milky-way-boat-sailing-3605547/",
              "type": "photo",
              "tags": "ocean, milky way, boat",
              "previewURL": "https://cdn.pixabay.com/photo/2018/08/14/13/23/ocean-3605547_150.jpg",
              "previewWidth": 150,
              "previewHeight": 97,
              "webformatURL": "https://pixabay.com/get/g070179a3edd9c5b3fbf85f6bbed8871767f99d28ce7204ccafc0181954459df64ccf1e3f7465e81e54deea8265b7c6581ba2e2f44a0a22ca179f0af4cec79381_640.jpg",
              "webformatWidth": 640,
              "webformatHeight": 415,
              "largeImageURL": "https://pixabay.com/get/g63f7f32c0f59300994b0a631aecd09c1ab3d36d41c2b1c9c411d9d7902786b4c3dc74fbb2c0dd00dad08e026908cdcf7b83923032475a899e4254f981c7fc880_1280.jpg",
              "imageWidth": 6000,
              "imageHeight": 3894,
              "imageSize": 3590092,
              "views": 5994031,
              "downloads": 3956881,
              "collections": 160594,
              "likes": 6360,
              "comments": 996,
              "user_id": 7645255,
              "user": "jplenio",
              "userImageURL": "https://cdn.pixabay.com/user/2024/06/10/13-43-32-848_250x250.jpg"
            }
          ]
        }
    """.trimIndent()
).map { UrlWithContentTestData(it.first, it.second) }