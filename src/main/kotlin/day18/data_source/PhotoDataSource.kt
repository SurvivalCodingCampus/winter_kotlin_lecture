package day18.data_source

import day18.dto.PhotoDto
import day18.dto.PixabayResponse
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.json.Json
import java.io.File
import java.io.IOException
import java.lang.IllegalArgumentException
import java.lang.NullPointerException

interface PhotoDataSource {
    suspend fun getPhotos(query: String): List<PhotoDto>
}

class PhotoDataSourceImpl : PhotoDataSource {
    private val client = HttpClient(CIO)
    override suspend fun getPhotos(query: String): List<PhotoDto> {

        // 빈 검색어 예외 상황 처리
        if (query.isEmpty()) {
            throw IllegalArgumentException()
        }

        val apiKey = File("apikey").readText()
        val url = "https://pixabay.com/api/?key=${apiKey}&q=${query}&image_type=photo&pretty=true"
        val httpResponse = client.get(url)

        // 서버 에러 예외 상황 처리
        if (httpResponse.status == HttpStatusCode.InternalServerError) {
            throw ServerResponseException(httpResponse, "server error")
        }

        val textData = httpResponse.bodyAsText()
        // 네트워크 에러(IOException) 예외 상황 처리
        val checkError = textData.substringBefore("]") + "]"
        if (checkError == "[ERROR 400]") {
            throw IOException("invalid url")
        }

        val data = Json.decodeFromString<PixabayResponse>(textData)
        return data.hits ?: throw NullPointerException("exception in PhotoDataSourceImpl.getPhotos()")
    }
}

class MockPhotoDataSourceImpl : PhotoDataSource {
    private val client = HttpClient(CIO)
    override suspend fun getPhotos(query: String): List<PhotoDto> {

        // 빈 검색어 예외 상황 처리
        if (query.isEmpty()) {
            throw IllegalArgumentException()
        }

        val apiKey = File("apikey").readText()
        val url = "https://pixabay.com/api/?key=${apiKey}&q=${query}&image_type=photo&pretty=true"
        val httpResponse = client.get(url)

        // 서버 에러 예외 상황 처리
        if (httpResponse.status == HttpStatusCode.InternalServerError) {
            throw ServerResponseException(httpResponse, "server error")
        }

        val textData = """
            {
                "total": 57702,
                "totalHits": 500,
                "hits": [
                    {
                        "id": 6760871,
                        "pageURL": "https://pixabay.com/photos/spring-roll-roll-food-vietnamese-6760871/",
                        "type": "photo",
                        "tags": "spring roll, roll, food",
                        "previewURL": "https://cdn.pixabay.com/photo/2021/11/01/15/52/spring-roll-6760871_150.jpg",
                        "previewWidth": 150,
                        "previewHeight": 100,
                        "webformatURL": "https://pixabay.com/get/gd76bd3ce9886d8d102a500af45f792063ee0511c8cdc0a1d803008ce5c23c8e3fe104ce11f96dc362ca76e3b37921fbd8484624b7082ac28450db8f151fc6650_640.jpg",
                        "webformatWidth": 640,
                        "webformatHeight": 427,
                        "largeImageURL": "https://pixabay.com/get/gd68ee30c22e1ecd0eb1cfcb1616f8cdadd24f0700517defb872321c443e60e8dd72bcdda0940f549d29eb8a946f0fb8c6a5932bb8d8c3d33b8fd2c5db941990a_1280.jpg",
                        "imageWidth": 6720,
                        "imageHeight": 4480,
                        "imageSize": 8166735,
                        "views": 46181,
                        "downloads": 35894,
                        "collections": 2404,
                        "likes": 100,
                        "comments": 11,
                        "user_id": 22873796,
                        "user": "phamkhanhquynhtrang",
                        "userImageURL": "https://cdn.pixabay.com/user/2021/11/02/07-16-38-660_250x250.jpeg"
                    },
                    {
                        "id": 8591539,
                        "pageURL": "https://pixabay.com/photos/apple-fruit-wet-food-8591539/",
                        "type": "photo",
                        "tags": "apple, fruit, wet",
                        "previewURL": "https://cdn.pixabay.com/photo/2024/02/23/08/27/apple-8591539_150.jpg",
                        "previewWidth": 150,
                        "previewHeight": 100,
                        "webformatURL": "https://pixabay.com/get/g4110f8b78c373d64c72dfde8d0035f92f7350873189bc2141149ac17019d6795f447c4cae1cd814b57612155eb938e1b99145a72ac6d6aec418b0dea43367420_640.jpg",
                        "webformatWidth": 640,
                        "webformatHeight": 427,
                        "largeImageURL": "https://pixabay.com/get/g08f2843671ff275c67ae9fa13a5b5e7082d6626bdbd2631497e8deb79dc90ca24caeab8b034875f2bc6c33395261c8caf435ce1eb66c06ded4139f1b79c240ab_1280.jpg",
                        "imageWidth": 6002,
                        "imageHeight": 4000,
                        "imageSize": 1943929,
                        "views": 67208,
                        "downloads": 58643,
                        "collections": 2321,
                        "likes": 260,
                        "comments": 27,
                        "user_id": 9285194,
                        "user": "guvo59",
                        "userImageURL": ""
                    },
                    {
                        "id": 494706,
                        "pageURL": "https://pixabay.com/photos/hamburger-snack-burger-gourmet-494706/",
                        "type": "photo",
                        "tags": "hamburger, snack, burger",
                        "previewURL": "https://cdn.pixabay.com/photo/2014/10/19/20/59/hamburger-494706_150.jpg",
                        "previewWidth": 150,
                        "previewHeight": 99,
                        "webformatURL": "https://pixabay.com/get/g67a9168777c403558defdbff36739431c8efbf46a840dc5341e255bf359e1fcd22388116e261326572334b3cb55673c9_640.jpg",
                        "webformatWidth": 640,
                        "webformatHeight": 426,
                        "largeImageURL": "https://pixabay.com/get/gf7bf207d1e5d32fef6fc66b1ad43126dd06bb997cae6885fa5a3bff59b43b8eae4bcaf86f71d95d449c150c1eba1173c7de118b0e32a3b51a426bd6c8b02fc8a_1280.jpg",
                        "imageWidth": 5184,
                        "imageHeight": 3456,
                        "imageSize": 3515807,
                        "views": 291611,
                        "downloads": 173072,
                        "collections": 8124,
                        "likes": 483,
                        "comments": 85,
                        "user_id": 80788,
                        "user": "niekverlaan",
                        "userImageURL": "https://cdn.pixabay.com/user/2014/05/19/00-26-35-848_250x250.jpg"
                    },
                    {
                        "id": 1932466,
                        "pageURL": "https://pixabay.com/photos/spaghetti-tomatoes-basil-1932466/",
                        "type": "photo",
                        "tags": "spaghetti, tomatoes, basil",
                        "previewURL": "https://cdn.pixabay.com/photo/2016/12/26/17/28/spaghetti-1932466_150.jpg",
                        "previewWidth": 150,
                        "previewHeight": 99,
                        "webformatURL": "https://pixabay.com/get/g862601b3aeecb4f2dab54218a7f36ced7d61dda516a03ff76993772602b7f78af64bfdf48a88621a346a3d6cbbfefb80e41e506268f0ca01ba735b626a080e08_640.jpg",
                        "webformatWidth": 640,
                        "webformatHeight": 423,
                        "largeImageURL": "https://pixabay.com/get/g74fe59e3adbab512c012f1c891b4ba51ecb8a69c2ab66e76c189e0be0e5fbbc7cd1853ceebff519adba5c10df7451c76dda16977e838239af15e3655f76bedf4_1280.jpg",
                        "imageWidth": 5685,
                        "imageHeight": 3765,
                        "imageSize": 9292153,
                        "views": 888091,
                        "downloads": 573827,
                        "collections": 19954,
                        "likes": 1505,
                        "comments": 272,
                        "user_id": 3938704,
                        "user": "Daria-Yakovleva",
                        "userImageURL": "https://cdn.pixabay.com/user/2016/12/06/15-05-11-524_250x250.jpg"
                    },
                    {
                        "id": 3550733,
                        "pageURL": "https://pixabay.com/photos/grapes-fruits-food-fresh-healthy-3550733/",
                        "type": "photo",
                        "tags": "grapes, fruits, food",
                        "previewURL": "https://cdn.pixabay.com/photo/2018/07/20/14/02/grapes-3550733_150.jpg",
                        "previewWidth": 150,
                        "previewHeight": 99,
                        "webformatURL": "https://pixabay.com/get/ged18851ba48096d701fac613c19a6204ed7e990d2b3bc56463aee2df67e57558d2cd15f78248b8ce2133c588992b56dc7641401e07aad3a820ebf2b248e2036f_640.jpg",
                        "webformatWidth": 640,
                        "webformatHeight": 426,
                        "largeImageURL": "https://pixabay.com/get/gd985460e21c3a68949793f2937d0388925115a04b2c9547cfc69f71ce5c6a2febe27b70e524493a00947a4b53d6f537e54cc4182d3f13e977d65710e51edadb9_1280.jpg",
                        "imageWidth": 6000,
                        "imageHeight": 4000,
                        "imageSize": 4145176,
                        "views": 250950,
                        "downloads": 190974,
                        "collections": 7393,
                        "likes": 805,
                        "comments": 123,
                        "user_id": 1161770,
                        "user": "Bru-nO",
                        "userImageURL": "https://cdn.pixabay.com/user/2023/04/18/15-01-28-484_250x250.jpg"
                    },
                    {
                        "id": 1085063,
                        "pageURL": "https://pixabay.com/photos/vegetables-fruits-food-ingredients-1085063/",
                        "type": "photo",
                        "tags": "vegetables, fruits, food",
                        "previewURL": "https://cdn.pixabay.com/photo/2015/12/09/17/11/vegetables-1085063_150.jpg",
                        "previewWidth": 150,
                        "previewHeight": 98,
                        "webformatURL": "https://pixabay.com/get/gef2b9990b9d7bf022edf3dab36110216209f4815e014a7c5b2aae4ce21f26dd1b208254db9f0cccec2380e74c5b53e62dfa6ef89e28372ab76ae503bd04e4c00_640.jpg",
                        "webformatWidth": 640,
                        "webformatHeight": 422,
                        "largeImageURL": "https://pixabay.com/get/g8faad792d433098d3372a855cb8fc34ae978681eabfae560096e250c18b209296ac0e91e5d7eeba7937e28cb7a4b5d4901fdaf042815f577551bedf8a3d08226_1280.jpg",
                        "imageWidth": 4050,
                        "imageHeight": 2676,
                        "imageSize": 1814596,
                        "views": 716969,
                        "downloads": 423608,
                        "collections": 19190,
                        "likes": 1243,
                        "comments": 303,
                        "user_id": 1643989,
                        "user": "dbreen",
                        "userImageURL": "https://cdn.pixabay.com/user/2015/11/14/15-22-41-548_250x250.jpg"
                    },
                    {
                        "id": 8577854,
                        "pageURL": "https://pixabay.com/photos/recipe-ravioli-food-pastry-8577854/",
                        "type": "photo",
                        "tags": "recipe, ravioli, food",
                        "previewURL": "https://cdn.pixabay.com/photo/2024/02/16/15/36/recipe-8577854_150.jpg",
                        "previewWidth": 112,
                        "previewHeight": 150,
                        "webformatURL": "https://pixabay.com/get/g326fb51de9b157f124f34c0dbe0c3e736b33446f36a174fafd74cbda6fb67b0d11489dbbde0319ff9d84823108a26630dcd6b735e9d5fa3a097a386a5ffcac53_640.jpg",
                        "webformatWidth": 480,
                        "webformatHeight": 640,
                        "largeImageURL": "https://pixabay.com/get/gc5ec17b1175c2c42d01f557c28461e7a00d969d182a5dbd363c542cd2aaf49156d5682387fa419d40c746a59b5b844e022dc88279531dbf8ecae2d85b20d899b_1280.jpg",
                        "imageWidth": 3024,
                        "imageHeight": 4032,
                        "imageSize": 4766082,
                        "views": 25427,
                        "downloads": 21929,
                        "collections": 426,
                        "likes": 57,
                        "comments": 10,
                        "user_id": 35796437,
                        "user": "35796437",
                        "userImageURL": ""
                    },
                    {
                        "id": 8031138,
                        "pageURL": "https://pixabay.com/photos/fish-fillet-vegetables-redfish-8031138/",
                        "type": "photo",
                        "tags": "fish, fillet, vegetables",
                        "previewURL": "https://cdn.pixabay.com/photo/2023/05/31/11/15/fish-8031138_150.jpg",
                        "previewWidth": 150,
                        "previewHeight": 100,
                        "webformatURL": "https://pixabay.com/get/g06f4f7f620653a846a69fe194811a27b6453c2af27bb4dbdcabccaf9a36c7deda41429e2f1ca00f2be838684059c27f72b9d9ba64572d130b29da3d16bc26f89_640.jpg",
                        "webformatWidth": 640,
                        "webformatHeight": 427,
                        "largeImageURL": "https://pixabay.com/get/g4364dade46d74253bc35d73d069d8f380e61d471abc73bb796d52777e34d012ca80a53084520e822f18efba7705c05cc7ee8ef04cf1aabcae031709ddc7470e1_1280.jpg",
                        "imageWidth": 6960,
                        "imageHeight": 4640,
                        "imageSize": 9031602,
                        "views": 28099,
                        "downloads": 23670,
                        "collections": 1010,
                        "likes": 71,
                        "comments": 17,
                        "user_id": 31315809,
                        "user": "eatde",
                        "userImageURL": "https://cdn.pixabay.com/user/2022/11/14/11-37-34-884_250x250.png"
                    },
                    {
                        "id": 8235059,
                        "pageURL": "https://pixabay.com/photos/mug-coffee-cup-black-breakfast-8235059/",
                        "type": "photo",
                        "tags": "mug, coffee, cup",
                        "previewURL": "https://cdn.pixabay.com/photo/2023/09/05/12/44/mug-8235059_150.jpg",
                        "previewWidth": 150,
                        "previewHeight": 100,
                        "webformatURL": "https://pixabay.com/get/g0e28f081ba45be62c095aed9bff00e0df719d8c379be4aeb1f0d3209d0e37545b9f94fcb5352e01c30c1062a062b086bd1efcfcb489229fbecb3df38589867ab_640.jpg",
                        "webformatWidth": 640,
                        "webformatHeight": 427,
                        "largeImageURL": "https://pixabay.com/get/g240d3ed23963d3913edd596e15d50d166ae8ebcf44b433931018d75802e2946a946ed23398173dd90975cf7c6c8eabe7c82973a58a21abe035ed4ea6016194fa_1280.jpg",
                        "imageWidth": 6000,
                        "imageHeight": 4000,
                        "imageSize": 3450946,
                        "views": 39243,
                        "downloads": 32548,
                        "collections": 1323,
                        "likes": 130,
                        "comments": 16,
                        "user_id": 30503507,
                        "user": "TheDesignLady87",
                        "userImageURL": "https://cdn.pixabay.com/user/2023/09/08/10-12-37-188_250x250.jpg"
                    },
                    {
                        "id": 7188630,
                        "pageURL": "https://pixabay.com/photos/porridge-breakfast-healthy-food-7188630/",
                        "type": "photo",
                        "tags": "porridge, breakfast, healthy food",
                        "previewURL": "https://cdn.pixabay.com/photo/2022/05/11/07/10/porridge-7188630_150.jpg",
                        "previewWidth": 100,
                        "previewHeight": 150,
                        "webformatURL": "https://pixabay.com/get/g96f13327e5aaf223735d111a2b8a2b48c19670bc63389842a2dcfb8f9f566dac4f9639841e42f9da99ef5b96cc525400c52240f8abe0a1df16e5fc7a27b2cc79_640.jpg",
                        "webformatWidth": 427,
                        "webformatHeight": 640,
                        "largeImageURL": "https://pixabay.com/get/g54b2e93041f5f1989d4b66af39278a9878dca503ec5e7c15a9f71708894e5383e7d21905d8127035453513fc4b66a0f8b99027b23b22f28d0eef4a3c721959bf_1280.jpg",
                        "imageWidth": 4000,
                        "imageHeight": 6000,
                        "imageSize": 5320893,
                        "views": 65850,
                        "downloads": 57588,
                        "collections": 1489,
                        "likes": 156,
                        "comments": 19,
                        "user_id": 27316068,
                        "user": "Smacznadietetyka",
                        "userImageURL": "https://cdn.pixabay.com/user/2022/05/10/17-24-55-195_250x250.jpg"
                    },
                    {
                        "id": 2977251,
                        "pageURL": "https://pixabay.com/photos/sandwich-food-flying-food-snack-2977251/",
                        "type": "photo",
                        "tags": "sandwich, food, flying food",
                        "previewURL": "https://cdn.pixabay.com/photo/2017/11/25/17/17/sandwich-2977251_150.jpg",
                        "previewWidth": 150,
                        "previewHeight": 150,
                        "webformatURL": "https://pixabay.com/get/g31383440d3b4d1f0012b0c2f907a6b681cb82f677163ed1166dcda98cb4c485524dad74795a3622f204a2c5cf0bd83a98c7bdedb5c52193a368cb4e8d2abef4f_640.jpg",
                        "webformatWidth": 640,
                        "webformatHeight": 640,
                        "largeImageURL": "https://pixabay.com/get/ge96d01e7b423ada2a758efcbb2d9731b3bf391a05a737513085b9558b7549a3319f6b9a0ac448a0bb6aa8ca740629c7370da2ab3a5b5848b212ea1124ced2caa_1280.jpg",
                        "imageWidth": 2835,
                        "imageHeight": 2835,
                        "imageSize": 1086701,
                        "views": 126725,
                        "downloads": 82349,
                        "collections": 2000,
                        "likes": 242,
                        "comments": 54,
                        "user_id": 443272,
                        "user": "Sponchia",
                        "userImageURL": "https://cdn.pixabay.com/user/2021/12/22/19-06-17-378_250x250.jpg"
                    },
                    {
                        "id": 8215179,
                        "pageURL": "https://pixabay.com/photos/cupcake-bakery-pastry-sweets-snack-8215179/",
                        "type": "photo",
                        "tags": "cupcake, bakery, pastry",
                        "previewURL": "https://cdn.pixabay.com/photo/2023/08/26/14/19/cupcake-8215179_150.jpg",
                        "previewWidth": 112,
                        "previewHeight": 150,
                        "webformatURL": "https://pixabay.com/get/gcd84118a37cde85481d3cafe34c6b3ed32097e6fe07316be5c710219231ca7e80d2193823a221af646e832cf211cec048a69451c1b2e39e24f02a783b4497776_640.jpg",
                        "webformatWidth": 480,
                        "webformatHeight": 640,
                        "largeImageURL": "https://pixabay.com/get/ge498b0ffbb3b34aefb9f75994abf30b277dfa3e39e9c539685a6a772c9a98498e4d25897a4545be3cdf34470541631932c9fb7ebf7742eaf57e24ea613b9589e_1280.jpg",
                        "imageWidth": 3024,
                        "imageHeight": 4032,
                        "imageSize": 1572081,
                        "views": 32108,
                        "downloads": 26341,
                        "collections": 663,
                        "likes": 96,
                        "comments": 15,
                        "user_id": 39067011,
                        "user": "PixelPerfectMom",
                        "userImageURL": "https://cdn.pixabay.com/user/2023/08/26/08-32-20-515_250x250.png"
                    },
                    {
                        "id": 329523,
                        "pageURL": "https://pixabay.com/photos/pizza-slices-italian-cuisine-329523/",
                        "type": "photo",
                        "tags": "pizza, slices, italian cuisine",
                        "previewURL": "https://cdn.pixabay.com/photo/2014/04/22/02/56/pizza-329523_150.jpg",
                        "previewWidth": 150,
                        "previewHeight": 88,
                        "webformatURL": "https://pixabay.com/get/gcc9589a1f77d4d658e86d63f7c9a3ec8f1dafc78093c442200fe492b56243dca60624ba887d9a2fca7c65ae836c8f46e_640.jpg",
                        "webformatWidth": 640,
                        "webformatHeight": 376,
                        "largeImageURL": "https://pixabay.com/get/ga59af065a5d9ad726dff701aec04e1650d84d151a207bdf259aef6ecbed7c1c37543389827d20582e5087070c96dfdba07bfa5503bc6176013efdd31416bc90b_1280.jpg",
                        "imageWidth": 3588,
                        "imageHeight": 2112,
                        "imageSize": 1558891,
                        "views": 234520,
                        "downloads": 129885,
                        "collections": 5912,
                        "likes": 377,
                        "comments": 81,
                        "user_id": 230533,
                        "user": "joshuemd",
                        "userImageURL": ""
                    },
                    {
                        "id": 366875,
                        "pageURL": "https://pixabay.com/photos/food-dishes-meals-cuisine-soup-366875/",
                        "type": "photo",
                        "tags": "food, dishes, meals",
                        "previewURL": "https://cdn.pixabay.com/photo/2014/06/11/17/00/food-366875_150.jpg",
                        "previewWidth": 150,
                        "previewHeight": 90,
                        "webformatURL": "https://pixabay.com/get/g1e99e46ccc8de6f7029c750a82091c401f265b381c064756ad1774ce7aa7f77cb50bcefa4cc60622f6b6ff96769f37bf_640.jpg",
                        "webformatWidth": 640,
                        "webformatHeight": 384,
                        "largeImageURL": "https://pixabay.com/get/gca2efbbe3bfae780387fe0c809d1bd8cd99a6ff66f7a15cb0cc81f2cee007aa4cc5ee277260849884d1fb8e992f459b27ff64b0171c48f34fd6d03e0f30d0e99_1280.jpg",
                        "imageWidth": 5000,
                        "imageHeight": 3000,
                        "imageSize": 5040661,
                        "views": 759228,
                        "downloads": 446824,
                        "collections": 11361,
                        "likes": 1127,
                        "comments": 304,
                        "user_id": 51581,
                        "user": "51581",
                        "userImageURL": ""
                    },
                    {
                        "id": 756601,
                        "pageURL": "https://pixabay.com/photos/cookie-bake-pastry-pastries-sweet-756601/",
                        "type": "photo",
                        "tags": "cookie, bake, pastry",
                        "previewURL": "https://cdn.pixabay.com/photo/2015/05/07/15/08/cookie-756601_150.jpg",
                        "previewWidth": 150,
                        "previewHeight": 100,
                        "webformatURL": "https://pixabay.com/get/g37557a56d13797a88932a4a21b9959c6721532e39b049d42d2009c3711efab2d7277f2b78555dcefd3b6841486accf84_640.jpg",
                        "webformatWidth": 640,
                        "webformatHeight": 430,
                        "largeImageURL": "https://pixabay.com/get/gbecd2c614af3467e9b7a7fdc8df7c85a648c1118c453017da6afa9392592a1ae8435ff209ccf9b57ce7d54d90ce5d0cc0a4ce828e3f8769c41c5896f0100ff29_1280.jpg",
                        "imageWidth": 4160,
                        "imageHeight": 2800,
                        "imageSize": 2332353,
                        "views": 219199,
                        "downloads": 135965,
                        "collections": 4110,
                        "likes": 522,
                        "comments": 71,
                        "user_id": 509903,
                        "user": "congerdesign",
                        "userImageURL": "https://cdn.pixabay.com/user/2023/11/06/12-07-49-892_250x250.jpg"
                    },
                    {
                        "id": 6142611,
                        "pageURL": "https://pixabay.com/photos/copyright-jackie-matthews-food-food-6142611/",
                        "type": "photo",
                        "tags": "copyright, jackie matthews, food",
                        "previewURL": "https://cdn.pixabay.com/photo/2021/04/01/15/39/copyright-6142611_150.jpg",
                        "previewWidth": 100,
                        "previewHeight": 150,
                        "webformatURL": "https://pixabay.com/get/g487158ff381937d49624645baeed9f69f68afdcc15e14cccc4ac42216040f24c127474b8043823f3267238032579fd1e1bc236c1049c7a2f327bbf12245ef6f7_640.jpg",
                        "webformatWidth": 427,
                        "webformatHeight": 640,
                        "largeImageURL": "https://pixabay.com/get/g0cae8a6ff6f4ecab2787ab616acdadf693fbed365187851ae05fe240660464560808ceaf44adb0594be6085dc8ffe208e7496fde07d3e8634b2f16b85c187530_1280.jpg",
                        "imageWidth": 3648,
                        "imageHeight": 5472,
                        "imageSize": 7055168,
                        "views": 27254,
                        "downloads": 22120,
                        "collections": 644,
                        "likes": 61,
                        "comments": 8,
                        "user_id": 20584384,
                        "user": "matthewsjackie",
                        "userImageURL": "https://cdn.pixabay.com/user/2021/03/08/12-55-16-434_250x250.jpg"
                    },
                    {
                        "id": 2931846,
                        "pageURL": "https://pixabay.com/photos/spaghetti-pasta-noodles-italian-2931846/",
                        "type": "photo",
                        "tags": "spaghetti, pasta, noodles",
                        "previewURL": "https://cdn.pixabay.com/photo/2017/11/08/22/18/spaghetti-2931846_150.jpg",
                        "previewWidth": 150,
                        "previewHeight": 84,
                        "webformatURL": "https://pixabay.com/get/g2476856c8b899c03bec36d153c088af505c3da1fab1da5633963051b0a0746034005b829be8f29eea7a26091addfebb148594562c1d9fb7051a36255bb717458_640.jpg",
                        "webformatWidth": 640,
                        "webformatHeight": 359,
                        "largeImageURL": "https://pixabay.com/get/g766d103be255bc1151a565d067906475adfc2dedbed54bc9eca982bdced70d521f28fe646cbda1c62df7576e002bf0c069821bf20606788ef2a47fc272968cd1_1280.jpg",
                        "imageWidth": 4420,
                        "imageHeight": 2486,
                        "imageSize": 2530639,
                        "views": 395091,
                        "downloads": 277431,
                        "collections": 9275,
                        "likes": 707,
                        "comments": 122,
                        "user_id": 110719,
                        "user": "Divily",
                        "userImageURL": "https://cdn.pixabay.com/user/2017/11/06/16-30-26-921_250x250.jpg"
                    },
                    {
                        "id": 8295778,
                        "pageURL": "https://pixabay.com/photos/sweet-potatoes-potatoes-cook-meal-8295778/",
                        "type": "photo",
                        "tags": "sweet potatoes, potatoes, cook",
                        "previewURL": "https://cdn.pixabay.com/photo/2023/10/05/11/47/sweet-potatoes-8295778_150.jpg",
                        "previewWidth": 150,
                        "previewHeight": 100,
                        "webformatURL": "https://pixabay.com/get/gda2216568730b874ea63090a7e40be7a99c7b8cbda7c08e02c8547f7ba9543212b15251c4e860f73349241df9d95b5313cd91a366a4ff4bf1aaf48d92c4fb911_640.jpg",
                        "webformatWidth": 640,
                        "webformatHeight": 427,
                        "largeImageURL": "https://pixabay.com/get/gd2ec2662a2236a4573bfb71206472e43e236596d132d923d1cfedb1e5297be5a3fb50261cc30786827cbc93aab60d62dea661f27bbcd69381784e2f2cd3e3e1f_1280.jpg",
                        "imageWidth": 5184,
                        "imageHeight": 3456,
                        "imageSize": 4195730,
                        "views": 22790,
                        "downloads": 20031,
                        "collections": 450,
                        "likes": 68,
                        "comments": 14,
                        "user_id": 2086402,
                        "user": "Mondgesicht",
                        "userImageURL": "https://cdn.pixabay.com/user/2018/01/07/11-01-02-821_250x250.jpg"
                    },
                    {
                        "id": 752153,
                        "pageURL": "https://pixabay.com/photos/vegetables-basket-vegetable-basket-752153/",
                        "type": "photo",
                        "tags": "vegetables, basket, vegetable basket",
                        "previewURL": "https://cdn.pixabay.com/photo/2015/05/04/10/16/vegetables-752153_150.jpg",
                        "previewWidth": 150,
                        "previewHeight": 102,
                        "webformatURL": "https://pixabay.com/get/g2230f63e870a8724f7ea69c2e97abd5999d7b13a827e1a1c2d1f1c1d7f6b4cfb77606b420ef6825de4b433cdc2a9ad0d_640.jpg",
                        "webformatWidth": 640,
                        "webformatHeight": 437,
                        "largeImageURL": "https://pixabay.com/get/gf5bf5f41e27d338cfe9e86a0a0addddd0b5c0dcd7856c14ed03f172f3a74bc8d1c2813e46bef855a03e61e2245be2568b6461a0e79d52a979c5dcb72bd42b3ef_1280.jpg",
                        "imageWidth": 4770,
                        "imageHeight": 3264,
                        "imageSize": 3117248,
                        "views": 750705,
                        "downloads": 407846,
                        "collections": 24801,
                        "likes": 1733,
                        "comments": 317,
                        "user_id": 509903,
                        "user": "congerdesign",
                        "userImageURL": "https://cdn.pixabay.com/user/2023/11/06/12-07-49-892_250x250.jpg"
                    },
                    {
                        "id": 7391738,
                        "pageURL": "https://pixabay.com/photos/strawberries-fruits-food-fresh-7391738/",
                        "type": "photo",
                        "tags": "strawberries, fruits, food",
                        "previewURL": "https://cdn.pixabay.com/photo/2022/08/17/07/10/strawberries-7391738_150.jpg",
                        "previewWidth": 150,
                        "previewHeight": 100,
                        "webformatURL": "https://pixabay.com/get/gdd941c0b5b496caf1de8c2e8977e7d07597ecb39ae0520e99a32c561ff5ddc2fb840da8cdaa10ed3242d8ceed4186b27606d231ee5157e305cde1de8cf807255_640.jpg",
                        "webformatWidth": 640,
                        "webformatHeight": 427,
                        "largeImageURL": "https://pixabay.com/get/g94987a93b55a0258f882ad8ea021d2e222052374f289c86da043247b548542750343cc9e94707f4b06ef40ea1472e48390340728711cace029baefc2dffda915_1280.jpg",
                        "imageWidth": 4000,
                        "imageHeight": 2666,
                        "imageSize": 2338837,
                        "views": 24739,
                        "downloads": 17767,
                        "collections": 1198,
                        "likes": 109,
                        "comments": 11,
                        "user_id": 6083034,
                        "user": "alipub",
                        "userImageURL": "https://cdn.pixabay.com/user/2021/08/22/21-08-30-236_250x250.jpg"
                    }
                ]
            }
        """.trimIndent()
        // 네트워크 에러(IOException) 예외 상황 처리
        val checkError = textData.substringBefore("]") + "]"
        if (checkError == "[ERROR 400]") {
            throw IOException("invalid url")
        }

        val data = Json.decodeFromString<PixabayResponse>(textData)
        return data.hits ?: throw NullPointerException("exception in PhotoDataSourceImpl.getPhotos()")
    }
}

class MockPhotoDataSourceImplTestServerError : PhotoDataSource {
    private val client = HttpClient(CIO)
    override suspend fun getPhotos(query: String): List<PhotoDto> {

        // 빈 검색어 예외 상황 처리
        if (query.isEmpty()) {
            throw IllegalArgumentException()
        }

        val apiKey = File("apikey").readText()
        val url = "https://pixabay.com/api/?key=${apiKey}&q=${query}&image_type=photo&pretty=true"
        val httpResponse = client.get(url)

        // 서버 에러 예외 상황 처리
        if (true) {
            throw ServerResponseException(httpResponse, "server error")
        }

        val textData = httpResponse.bodyAsText()
        // 네트워크 에러(IOException) 예외 상황 처리
        val checkError = textData.substringBefore("]") + "]"
        if (checkError == "[ERROR 400]") {
            throw IOException("invalid url")
        }

        val data = Json.decodeFromString<PixabayResponse>(textData)
        return data.hits ?: throw NullPointerException("exception in PhotoDataSourceImpl.getPhotos()")
    }
}

class MockPhotoDataSourceImplNetworkError : PhotoDataSource {
    private val client = HttpClient(CIO)
    override suspend fun getPhotos(query: String): List<PhotoDto> {

        // 빈 검색어 예외 상황 처리
        if (query.isEmpty()) {
            throw IllegalArgumentException()
        }

        val apiKey = File("apikey").readText()
        val url = "https://pixabay.com/api/?key=${apiKey}&q=${query}&image_type=photo&pretty=true"
        val httpResponse = client.get(url)

        // 서버 에러 예외 상황 처리
        if (httpResponse.status == HttpStatusCode.InternalServerError) {
            throw ServerResponseException(httpResponse, "server error")
        }

        val textData = httpResponse.bodyAsText()
        // 네트워크 에러(IOException) 예외 상황 처리
        val checkError = textData.substringBefore("]") + "]"
        if (true) {
            throw IOException("invalid url")
        }

        val data = Json.decodeFromString<PixabayResponse>(textData)
        return data.hits ?: throw NullPointerException("exception in PhotoDataSourceImpl.getPhotos()")
    }
}


