package day18

import day18.datasource.PixabayDataSource
import day18.util.Result
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.util.network.*
import io.ktor.utils.io.*
import kotlinx.coroutines.test.runTest
import org.junit.Assert
import org.junit.Test

class PhotoRepositoryImplTest {

    @Test
    fun `test error results`() = runTest {
        val mockEngine = MockEngine { request ->
            respond(
                content = ByteReadChannel.Empty,
                status = HttpStatusCode.InternalServerError,
            )
        }
        val repo = PhotoRepositoryImpl(PixabayDataSource(httpClientEngine = mockEngine))
        val emptyQuery = repo.getPhotos(" ", "   ")

        check(emptyQuery is Result.Error)
        Assert.assertTrue(emptyQuery.error is PhotoError.EmptyQuery)

        val result = repo.getPhotos("yellow", "flowers")
        check(result is Result.Error)
        Assert.assertTrue(result.error is PhotoError.ServerError)
    }

    @Test
    fun `test offline scenario`() = runTest {
        val mockEngine = MockEngine {
            throw UnresolvedAddressException()
        }

        val repo = PhotoRepositoryImpl(PixabayDataSource(httpClientEngine = mockEngine))
        val noNetwork = repo.getPhotos("yellow")

        check(noNetwork is Result.Error)
        Assert.assertTrue(noNetwork.error is PhotoError.NetworkError)
    }

    @Test
    fun `test good case`() = runTest {
        val mockEngine = MockEngine { request ->
            respond(
                content = ByteReadChannel(
                    """
                    {
                        "total": 35987,
                        "totalHits": 500,
                        "hits": [
                            {
                                "id": 1512813,
                                "pageURL": "https://pixabay.com/photos/lilies-yellow-flowers-petals-1512813/",
                                "type": "photo",
                                "tags": "lilies, yellow, flowers",
                                "previewURL": "https://cdn.pixabay.com/photo/2016/07/12/18/54/lilies-1512813_150.jpg",
                                "previewWidth": 150,
                                "previewHeight": 75,
                                "webformatURL": "https://pixabay.com/get/g89186e895bc2fc3d0080969294922b16767dba16e537e3281d2179dc9774fa1b95191f5ee0fbc5f92fdb9ecf6544b3f182bd3d769dd33392f17ed3d20c2bb5a7_640.jpg",
                                "webformatWidth": 640,
                                "webformatHeight": 323,
                                "largeImageURL": "https://pixabay.com/get/gbc50637c85e684281cca6960d8a05e665e4db85884acfe9a8ca947487eef3858c1bbcce06640a56fe687901c55e7e1577f4b13b09f62c4d6132009f31b5c407b_1280.jpg",
                                "imageWidth": 3861,
                                "imageHeight": 1952,
                                "imageSize": 1037708,
                                "views": 224163,
                                "downloads": 140344,
                                "collections": 3960,
                                "likes": 654,
                                "comments": 66,
                                "user_id": 2364555,
                                "user": "NoName_13",
                                "userImageURL": "https://cdn.pixabay.com/user/2022/12/12/07-40-59-226_250x250.jpg"
                            },
                            {
                                "id": 6742560,
                                "pageURL": "https://pixabay.com/photos/lily-flower-yellow-flower-pistil-6742560/",
                                "type": "photo",
                                "tags": "lily, flower, yellow flower",
                                "previewURL": "https://cdn.pixabay.com/photo/2021/10/26/05/16/lily-6742560_150.jpg",
                                "previewWidth": 150,
                                "previewHeight": 100,
                                "webformatURL": "https://pixabay.com/get/g9b5d25681bdcaa1f38d2ba45e5ae1ebd55caba13579c9b4c8e215c1013f490e62ebd976aca20bcd3b7a770bc4f1e4ddc3fbc51ece427d4d7d4cf535ab5fcb9e3_640.jpg",
                                "webformatWidth": 640,
                                "webformatHeight": 427,
                                "largeImageURL": "https://pixabay.com/get/g3f0e40d0938bb0174e459412d54560e1fbf569012efa11cad219bff34a4cce1b250b9db7183a19062a2496f28a5f26144532d36e61864933d5a0ac741e2fc47c_1280.jpg",
                                "imageWidth": 7952,
                                "imageHeight": 5304,
                                "imageSize": 4764142,
                                "views": 47847,
                                "downloads": 39618,
                                "collections": 1716,
                                "likes": 131,
                                "comments": 73,
                                "user_id": 21428489,
                                "user": "ignartonosbg",
                                "userImageURL": "https://cdn.pixabay.com/user/2024/01/14/15-44-01-243_250x250.jpg"
                            }
                        ]
                    }
                """.trimIndent()
                ),
                status = HttpStatusCode.OK,
                headers = headersOf(HttpHeaders.ContentType, "application/json")
            )
        }
        val repo = PhotoRepositoryImpl(PixabayDataSource(httpClientEngine = mockEngine))

        val result = repo.getPhotos("yellow", "flowers")
        check(result is Result.Success)
        Assert.assertEquals(2, result.data.size)
        Assert.assertEquals(
            "https://pixabay.com/get/gbc50637c85e684281cca6960d8a05e665e4db85884acfe9a8ca947487eef3858c1bbcce06640a56fe687901c55e7e1577f4b13b09f62c4d6132009f31b5c407b_1280.jpg",
            result.data.first().imageUrl
        )
    }

}