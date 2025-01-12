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
        Assert.assertTrue(emptyQuery.error is PhotoError.ServerError)
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
                                "id": 7679117,
                                "pageURL": "https://pixabay.com/photos/flower-stamens-hypericum-macro-7679117/",
                                "type": "photo",
                                "tags": "flower, stamens, hypericum",
                                "previewURL": "https://cdn.pixabay.com/photo/2022/12/26/13/50/flower-7679117_150.jpg",
                                "previewWidth": 150,
                                "previewHeight": 100,
                                "webformatURL": "https://pixabay.com/get/g1ba96451365ac79ba5769e66f3b28122c136ef85251d6cb47443a1656f6583379816a2038945418dd79143a042da87dc53074d32ff9223eb33ffcdf105e3e5d9_640.jpg",
                                "webformatWidth": 640,
                                "webformatHeight": 427,
                                "largeImageURL": "https://pixabay.com/get/g469ea40f2c4957df869a23335143008c95aec6fd07ce0151bbdb8794bbc61c844e63f57e0600b5d77d4fa2a686649f469ea95bc6bea3425ea1305097cef096f3_1280.jpg",
                                "imageWidth": 6000,
                                "imageHeight": 4000,
                                "imageSize": 8137356,
                                "views": 26174,
                                "downloads": 20051,
                                "collections": 844,
                                "likes": 122,
                                "comments": 20,
                                "user_id": 4379051,
                                "user": "Alfred_Grupstra",
                                "userImageURL": "https://cdn.pixabay.com/user/2024/08/25/22-05-08-334_250x250.jpg"
                            },
                            {
                                "id": 4295713,
                                "pageURL": "https://pixabay.com/photos/yellow-poppy-flower-yellow-flower-4295713/",
                                "type": "photo",
                                "tags": "yellow poppy, flower, yellow flower",
                                "previewURL": "https://cdn.pixabay.com/photo/2019/06/24/10/49/yellow-poppy-4295713_150.jpg",
                                "previewWidth": 150,
                                "previewHeight": 99,
                                "webformatURL": "https://pixabay.com/get/g44fb078d5401a24338abac5c41d8a11792fdc3fb23ee433f3a9de5ead1f7366bb8d5b0919f08b085c93d89dac4c6aa0f0efd4b2655672e6d18e594d58d3065d6_640.jpg",
                                "webformatWidth": 640,
                                "webformatHeight": 426,
                                "largeImageURL": "https://pixabay.com/get/g1cac13d0f7decb6c8546be005ec886a1f6f134cc38dba742d6e501a89120a4e95d4395cab2b905354055aa32bb27b5c1c274e3168a254ac9d8603eaa43dba506_1280.jpg",
                                "imageWidth": 6000,
                                "imageHeight": 4000,
                                "imageSize": 4738491,
                                "views": 9677,
                                "downloads": 5167,
                                "collections": 577,
                                "likes": 71,
                                "comments": 9,
                                "user_id": 7001566,
                                "user": "IngeGG",
                                "userImageURL": "https://cdn.pixabay.com/user/2019/06/19/10-30-15-601_250x250.jpg"
                            },
                            {
                                "id": 6316445,
                                "pageURL": "https://pixabay.com/photos/rapeseeds-yellow-flowers-6316445/",
                                "type": "photo",
                                "tags": "rapeseeds, yellow, flowers",
                                "previewURL": "https://cdn.pixabay.com/photo/2021/06/06/21/55/rapeseeds-6316445_150.jpg",
                                "previewWidth": 150,
                                "previewHeight": 100,
                                "webformatURL": "https://pixabay.com/get/g6650e4d4e3650ee96edcb8ebc26a9c0431df60486d147e99d480bd322ea00dfbb0752b74b455919e5c61fe588b85ffdf554a1912a8e97cf690b1ebfc1220fcd8_640.jpg",
                                "webformatWidth": 640,
                                "webformatHeight": 427,
                                "largeImageURL": "https://pixabay.com/get/g5eb38363288e1ad726f66006df6deddd594ed20a4f9b5e7328c07984bbf98429db2c997252f8c8576a16630aaf5d7770808b3b9f2c2d05abff628a247afbbfa3_1280.jpg",
                                "imageWidth": 6000,
                                "imageHeight": 4000,
                                "imageSize": 7735260,
                                "views": 37283,
                                "downloads": 29853,
                                "collections": 936,
                                "likes": 88,
                                "comments": 21,
                                "user_id": 11378535,
                                "user": "__Tatius__",
                                "userImageURL": "https://cdn.pixabay.com/user/2020/10/16/11-47-36-873_250x250.jpeg"
                            },
                            {
                                "id": 6162613,
                                "pageURL": "https://pixabay.com/photos/yellow-rose-rose-flower-cereal-6162613/",
                                "type": "photo",
                                "tags": "yellow rose, rose, flower",
                                "previewURL": "https://cdn.pixabay.com/photo/2021/04/08/18/59/yellow-rose-6162613_150.jpg",
                                "previewWidth": 150,
                                "previewHeight": 100,
                                "webformatURL": "https://pixabay.com/get/gd660df2d5899d25129af471bd48f006d5bbceee9ac05c6645608926284ba93a84baa8779bc0f51d5fd4a5ccc0aad386b340a100b67af57277ee5f947f84577f4_640.jpg",
                                "webformatWidth": 640,
                                "webformatHeight": 427,
                                "largeImageURL": "https://pixabay.com/get/g503551091e02a35849807488de4e25378d9c46b02f848ea75491d6bee323ad37acb09d3bc6f99adc0c7073e51f7cc611e1e703ba02cb67defec53a1c98ed49c2_1280.jpg",
                                "imageWidth": 4240,
                                "imageHeight": 2832,
                                "imageSize": 2389361,
                                "views": 56656,
                                "downloads": 42286,
                                "collections": 1834,
                                "likes": 286,
                                "comments": 199,
                                "user_id": 9363663,
                                "user": "Nowaja",
                                "userImageURL": "https://cdn.pixabay.com/user/2020/09/15/15-16-12-52_250x250.jpg"
                            },
                            {
                                "id": 6520851,
                                "pageURL": "https://pixabay.com/photos/flower-yellow-flower-bloom-blossom-6520851/",
                                "type": "photo",
                                "tags": "flower, yellow flower, bloom",
                                "previewURL": "https://cdn.pixabay.com/photo/2021/08/04/02/02/flower-6520851_150.jpg",
                                "previewWidth": 150,
                                "previewHeight": 103,
                                "webformatURL": "https://pixabay.com/get/g748a8403a0b26fb46ce9714ab0d0b15d37c737d10873a5daf4c0959310d1510c656ceea41f675252eb18cda819d933b502b1a2bf06264bbfc7fbd7c0933eabdf_640.jpg",
                                "webformatWidth": 640,
                                "webformatHeight": 439,
                                "largeImageURL": "https://pixabay.com/get/gde821318e7d3a590962c34e5b5db03e8871ca9b893d5836ab8abaca97ef2b15957ceb0a98bb1fde330a732187500631cdb924e041ede6d869d3302133777e6cf_1280.jpg",
                                "imageWidth": 3910,
                                "imageHeight": 2680,
                                "imageSize": 3171422,
                                "views": 17385,
                                "downloads": 9573,
                                "collections": 1443,
                                "likes": 106,
                                "comments": 21,
                                "user_id": 6246704,
                                "user": "fernandozhiminaicela",
                                "userImageURL": "https://cdn.pixabay.com/user/2019/02/27/14-16-13-192_250x250.jpg"
                            },
                            {
                                "id": 6558487,
                                "pageURL": "https://pixabay.com/photos/flowers-coast-sea-yellow-flowers-6558487/",
                                "type": "photo",
                                "tags": "flowers, coast, sea",
                                "previewURL": "https://cdn.pixabay.com/photo/2021/08/19/16/31/flowers-6558487_150.jpg",
                                "previewWidth": 150,
                                "previewHeight": 100,
                                "webformatURL": "https://pixabay.com/get/g91aded2d010dc90ce22efacaf70b4dfdb40c4ce63ba8b2dc7047a5060447a618e35b60b76205272d9653e125942e410af22f58513c911ab2b31f84433c3996fc_640.jpg",
                                "webformatWidth": 640,
                                "webformatHeight": 426,
                                "largeImageURL": "https://pixabay.com/get/g7319222854afe19883fa21ddb40e87f0a8d6041aad2dd9834fa1bb7e04c1b97b39ff98b73439e2fba4ab49d54048a7ee1da6b242e35accb8f25f7b1c025f7457_1280.jpg",
                                "imageWidth": 4256,
                                "imageHeight": 2832,
                                "imageSize": 4587665,
                                "views": 177457,
                                "downloads": 149499,
                                "collections": 6051,
                                "likes": 334,
                                "comments": 40,
                                "user_id": 21633244,
                                "user": "lillolillolillo",
                                "userImageURL": "https://cdn.pixabay.com/user/2021/06/09/06-56-51-212_250x250.jpg"
                            },
                            {
                                "id": 4750726,
                                "pageURL": "https://pixabay.com/photos/flower-petals-bloom-yellow-yellow-4750726/",
                                "type": "photo",
                                "tags": "flower, petals, bloom",
                                "previewURL": "https://cdn.pixabay.com/photo/2020/01/08/17/32/flower-4750726_150.jpg",
                                "previewWidth": 150,
                                "previewHeight": 99,
                                "webformatURL": "https://pixabay.com/get/g09118d8165d321bc2d0bea7149dc9bf856400089b445782ef64f786b36892d6c607bd5f87cecf91711daf6bb473a4f8bfa631fed357d8f284814fb45470db346_640.jpg",
                                "webformatWidth": 640,
                                "webformatHeight": 425,
                                "largeImageURL": "https://pixabay.com/get/g95b93dfc2f7cfedb07377f448c9b9c5e0739b8969c56a3f12430d1a1dd69ac353d271869e17c6ab84251723f01dc1f963e1338b6f0e7cfc383144a6da7409db5_1280.jpg",
                                "imageWidth": 3008,
                                "imageHeight": 2000,
                                "imageSize": 1453867,
                                "views": 10397,
                                "downloads": 7005,
                                "collections": 504,
                                "likes": 64,
                                "comments": 24,
                                "user_id": 14174246,
                                "user": "Zotx",
                                "userImageURL": "https://cdn.pixabay.com/user/2019/11/20/20-56-12-836_250x250.jpg"
                            },
                            {
                                "id": 7019264,
                                "pageURL": "https://pixabay.com/photos/flower-petal-wet-macro-tulip-7019264/",
                                "type": "photo",
                                "tags": "flower, petal, wet",
                                "previewURL": "https://cdn.pixabay.com/photo/2022/02/17/18/22/flower-7019264_150.jpg",
                                "previewWidth": 150,
                                "previewHeight": 100,
                                "webformatURL": "https://pixabay.com/get/gcf14a44bdaa882f30a22a64a282647ac96d4fc2ce8901a98a2b1b2f5ab03ee4972cadea7c2415d3a39e5af5bdad98052bc704c70f2cfbca0b841021c0cfc7539_640.jpg",
                                "webformatWidth": 640,
                                "webformatHeight": 427,
                                "largeImageURL": "https://pixabay.com/get/g3adf40c3556cdfd55b7a517b0b19673ee42068da00297faa13f10179f62c205adf6be5c44e11e463876db0999cf8c61c462a2eca2f09d0360b513964ff914819_1280.jpg",
                                "imageWidth": 6001,
                                "imageHeight": 4000,
                                "imageSize": 3386198,
                                "views": 31868,
                                "downloads": 26180,
                                "collections": 1877,
                                "likes": 160,
                                "comments": 25,
                                "user_id": 19662978,
                                "user": "angelicavaihel",
                                "userImageURL": "https://cdn.pixabay.com/user/2021/03/15/08-35-41-698_250x250.png"
                            },
                            {
                                "id": 7927829,
                                "pageURL": "https://pixabay.com/photos/bird-sunbird-olive-backed-sunbird-7927829/",
                                "type": "photo",
                                "tags": "bird, sunbird, olive-backed sunbird",
                                "previewURL": "https://cdn.pixabay.com/photo/2023/04/15/14/21/bird-7927829_150.jpg",
                                "previewWidth": 100,
                                "previewHeight": 150,
                                "webformatURL": "https://pixabay.com/get/ga62e20e5ed910cd9d52a123c465de4a409b7323ead4df493715ccc560abef9c262c68830d67d8fdccc69c8d1df8ab57828611e4f87b9ce8e7090b197d0eaf0e9_640.jpg",
                                "webformatWidth": 427,
                                "webformatHeight": 640,
                                "largeImageURL": "https://pixabay.com/get/g390fbb18868029f404346773cb3a4c7df0861a49cdb0fb818617a650b2c936104aaa40aaa499db5829ed41187191207b5fa79d0d5002bb6651d62ad352de49ac_1280.jpg",
                                "imageWidth": 3758,
                                "imageHeight": 5637,
                                "imageSize": 3640356,
                                "views": 59802,
                                "downloads": 52309,
                                "collections": 1545,
                                "likes": 191,
                                "comments": 38,
                                "user_id": 15871962,
                                "user": "xiSerge",
                                "userImageURL": "https://cdn.pixabay.com/user/2022/06/04/07-00-41-258_250x250.jpg"
                            },
                            {
                                "id": 7193390,
                                "pageURL": "https://pixabay.com/photos/flower-ranunculus-petals-dark-7193390/",
                                "type": "photo",
                                "tags": "flower, ranunculus, petals",
                                "previewURL": "https://cdn.pixabay.com/photo/2022/05/13/10/35/flower-7193390_150.jpg",
                                "previewWidth": 150,
                                "previewHeight": 100,
                                "webformatURL": "https://pixabay.com/get/gc52cc0a3ea9777008b78c3818cfa4b94943f0febef110a8af1665199514003dd28aefd7f6ad11e3b6689a2e2791eb417338c71d67d47dbfae8ca2b2c94b17b4f_640.jpg",
                                "webformatWidth": 640,
                                "webformatHeight": 427,
                                "largeImageURL": "https://pixabay.com/get/g335550f9edf2d1d0feb16fa9dfe4c037ee2a7e3fe78b6b3fbe72bc0ee9b8c4ef0f0b3ecc752423744316cd2ff98ab8254d54050a1167acd43f473840b888f68f_1280.jpg",
                                "imageWidth": 5472,
                                "imageHeight": 3648,
                                "imageSize": 2311191,
                                "views": 13664,
                                "downloads": 9783,
                                "collections": 1267,
                                "likes": 104,
                                "comments": 11,
                                "user_id": 25590070,
                                "user": "nohopuku_photography",
                                "userImageURL": "https://cdn.pixabay.com/user/2023/10/17/09-33-11-665_250x250.jpg"
                            },
                            {
                                "id": 4936511,
                                "pageURL": "https://pixabay.com/photos/flowers-yellow-flowers-nature-4936511/",
                                "type": "photo",
                                "tags": "flowers, yellow flowers, nature",
                                "previewURL": "https://cdn.pixabay.com/photo/2020/03/16/10/27/flowers-4936511_150.jpg",
                                "previewWidth": 150,
                                "previewHeight": 100,
                                "webformatURL": "https://pixabay.com/get/gc6c07f91f816030c6762243d5608a0a65033a76a030c2bbfdc97be2094c07da6d6212309ec7d6c8dd0387517a5b7cad684583fd61d0581e3358c1607a1705007_640.jpg",
                                "webformatWidth": 640,
                                "webformatHeight": 427,
                                "largeImageURL": "https://pixabay.com/get/g55dc6ac1ad642d72332d7ca36cc6376a97a5baace6fe0133c545c5a92125d85f64ea0bfad5acaf6e0c0256b5ab9b305a5c4b5814a3a0b3393e42553e574efa5a_1280.jpg",
                                "imageWidth": 5000,
                                "imageHeight": 3333,
                                "imageSize": 2156782,
                                "views": 35385,
                                "downloads": 22601,
                                "collections": 1248,
                                "likes": 127,
                                "comments": 21,
                                "user_id": 3603324,
                                "user": "phtorxp",
                                "userImageURL": "https://cdn.pixabay.com/user/2022/11/27/11-56-03-466_250x250.jpg"
                            },
                            {
                                "id": 273391,
                                "pageURL": "https://pixabay.com/photos/flower-yellow-petals-yellow-flower-273391/",
                                "type": "photo",
                                "tags": "flower, yellow petals, yellow flower",
                                "previewURL": "https://cdn.pixabay.com/photo/2014/02/24/05/11/flower-273391_150.jpg",
                                "previewWidth": 150,
                                "previewHeight": 112,
                                "webformatURL": "https://pixabay.com/get/g0bb9d4df86755a258957edcde11dabc8130b946e6986b90a84de3b82cdb6d2bd895c9b1a50808b92e2246130e824c48e_640.jpg",
                                "webformatWidth": 640,
                                "webformatHeight": 480,
                                "largeImageURL": "https://pixabay.com/get/gb048884b2a94e13b8bdf78015ea2442c91c3c5e71031328419475ba1b2cd52482a2d3e216503d2a91eede4a5093cc4893b2f5cc7aefcfb7c7847bc1815a27bb6_1280.jpg",
                                "imageWidth": 2607,
                                "imageHeight": 1956,
                                "imageSize": 890318,
                                "views": 25515,
                                "downloads": 9159,
                                "collections": 526,
                                "likes": 86,
                                "comments": 14,
                                "user_id": 152861,
                                "user": "angelac72",
                                "userImageURL": "https://cdn.pixabay.com/user/2014/02/10/02-47-32-118_250x250.jpg"
                            },
                            {
                                "id": 715540,
                                "pageURL": "https://pixabay.com/photos/yellow-flower-blossom-bloom-petals-715540/",
                                "type": "photo",
                                "tags": "yellow, flower, blossom",
                                "previewURL": "https://cdn.pixabay.com/photo/2015/04/10/00/41/yellow-715540_150.jpg",
                                "previewWidth": 150,
                                "previewHeight": 84,
                                "webformatURL": "https://pixabay.com/get/gc93fbd701419b601aae8721db811341714802a93f6ca6f02385bf87632fbaf7e2931b7baacc04abbd4eb33f83187f74b_640.jpg",
                                "webformatWidth": 640,
                                "webformatHeight": 360,
                                "largeImageURL": "https://pixabay.com/get/gf2b52fdf56322fd7a25e1bf759424a5c1993920643a79202a3016a8776ab2e2dbeeae8a5363913d5119e5ffcdde266a9200b87774436e304bc7628e8d0cf2424_1280.jpg",
                                "imageWidth": 3020,
                                "imageHeight": 1703,
                                "imageSize": 974940,
                                "views": 178867,
                                "downloads": 110083,
                                "collections": 2171,
                                "likes": 410,
                                "comments": 54,
                                "user_id": 916237,
                                "user": "Wow_Pho",
                                "userImageURL": "https://cdn.pixabay.com/user/2015/04/07/14-10-15-590_250x250.jpg"
                            },
                            {
                                "id": 6553135,
                                "pageURL": "https://pixabay.com/photos/jerusalem-artichoke-flower-6553135/",
                                "type": "photo",
                                "tags": "jerusalem artichoke, flower, yellow flower",
                                "previewURL": "https://cdn.pixabay.com/photo/2021/08/17/13/56/jerusalem-artichoke-6553135_150.jpg",
                                "previewWidth": 150,
                                "previewHeight": 100,
                                "webformatURL": "https://pixabay.com/get/gffc9f27b9b2eb3427b6ee78f6f1df86385fcc759d1ba51ca18321527a26f5ee9f79db1202aa42d7becf4ae86bc7c88c836b2eb40f360168cdc6978a98a92b3a0_640.jpg",
                                "webformatWidth": 640,
                                "webformatHeight": 427,
                                "largeImageURL": "https://pixabay.com/get/g74fa8bebff032f067cebffd00760b1fcf26e23dace749f8000a01a9d30172cedfcc757d767f31161228dea957c98314730ddb29e1b6e23b131bbfb17de533595_1280.jpg",
                                "imageWidth": 6240,
                                "imageHeight": 4160,
                                "imageSize": 2866091,
                                "views": 8355,
                                "downloads": 6085,
                                "collections": 530,
                                "likes": 112,
                                "comments": 59,
                                "user_id": 1195798,
                                "user": "Couleur",
                                "userImageURL": "https://cdn.pixabay.com/user/2024/11/29/15-20-47-533_250x250.jpg"
                            },
                            {
                                "id": 4384750,
                                "pageURL": "https://pixabay.com/photos/flower-yellow-flower-plant-macro-4384750/",
                                "type": "photo",
                                "tags": "flower, yellow flower, plant",
                                "previewURL": "https://cdn.pixabay.com/photo/2019/08/04/20/48/flower-4384750_150.jpg",
                                "previewWidth": 150,
                                "previewHeight": 100,
                                "webformatURL": "https://pixabay.com/get/ga7749442661ccac6ec5a41dccd50edfbd5c129aba2bdc39793c1b91fe9c705cf3dd909be1fcf6dfbd249a1c9a683820c4344d88da4ab0e4883fea2641011983a_640.jpg",
                                "webformatWidth": 640,
                                "webformatHeight": 427,
                                "largeImageURL": "https://pixabay.com/get/g794914b6686ad4136fbf8487a5234eb812daa06b03346f1ccd35ee898543250de2e0a799f44b1551046361442c1d1454ce8cc9deb9d998f1bc9e51bf4f9c2de7_1280.jpg",
                                "imageWidth": 5286,
                                "imageHeight": 3532,
                                "imageSize": 1161871,
                                "views": 4998,
                                "downloads": 3511,
                                "collections": 190,
                                "likes": 48,
                                "comments": 26,
                                "user_id": 7520060,
                                "user": "DerWeg",
                                "userImageURL": "https://cdn.pixabay.com/user/2023/07/09/08-27-31-784_250x250.jpg"
                            },
                            {
                                "id": 256776,
                                "pageURL": "https://pixabay.com/photos/flowers-yellow-flowers-plants-256776/",
                                "type": "photo",
                                "tags": "flowers, yellow flowers, plants",
                                "previewURL": "https://cdn.pixabay.com/photo/2014/02/02/15/05/flowers-256776_150.jpg",
                                "previewWidth": 150,
                                "previewHeight": 100,
                                "webformatURL": "https://pixabay.com/get/gfb92e1a7f1ea80f2fa9d1df56e49ca3403e15bfaec9d12cc0339f5d76b468fce195306322a63f9150e9645556f8c74ec_640.jpg",
                                "webformatWidth": 640,
                                "webformatHeight": 428,
                                "largeImageURL": "https://pixabay.com/get/g11d3e72102d69fbd074dbc82ad784b30d1a7f3f143ebae3a888a1c0573d9f110987f0c01091456a654e542ed44517bb0b8fe1fc1eaa0183a09e83131ba40ad96_1280.jpg",
                                "imageWidth": 3872,
                                "imageHeight": 2592,
                                "imageSize": 2371385,
                                "views": 14728,
                                "downloads": 7433,
                                "collections": 918,
                                "likes": 107,
                                "comments": 22,
                                "user_id": 768,
                                "user": "GLady",
                                "userImageURL": "https://cdn.pixabay.com/user/2023/02/23/18-02-16-112_250x250.jpg"
                            },
                            {
                                "id": 4297647,
                                "pageURL": "https://pixabay.com/photos/tulip-flower-yellow-flower-petals-4297647/",
                                "type": "photo",
                                "tags": "tulip, flower, yellow flower",
                                "previewURL": "https://cdn.pixabay.com/photo/2019/06/25/07/21/tulip-4297647_150.jpg",
                                "previewWidth": 120,
                                "previewHeight": 150,
                                "webformatURL": "https://pixabay.com/get/g86bc63bd0e4c27ed6107674aa69355b720ce2412d24752c2b3d67c1f3bd7997c8b6863631f0f3856c25bbad6f5e8da4eed4ab8add298928153c7c6058164f0be_640.jpg",
                                "webformatWidth": 512,
                                "webformatHeight": 640,
                                "largeImageURL": "https://pixabay.com/get/g1c9729dc0ee61c81db1f26c70ca6f826b812d6a48aecef4dbefc02f08a150bf05acb678eec1527249e3a29ed94463f8bff3ca478d5c3578b903f478f30ea8764_1280.jpg",
                                "imageWidth": 3576,
                                "imageHeight": 4472,
                                "imageSize": 721590,
                                "views": 18590,
                                "downloads": 15119,
                                "collections": 273,
                                "likes": 40,
                                "comments": 6,
                                "user_id": 12868935,
                                "user": "macroviewpoint",
                                "userImageURL": "https://cdn.pixabay.com/user/2024/10/23/17-23-17-155_250x250.jpg"
                            },
                            {
                                "id": 7341288,
                                "pageURL": "https://pixabay.com/photos/flower-yellow-flower-petals-7341288/",
                                "type": "photo",
                                "tags": "flower, yellow flower, petals",
                                "previewURL": "https://cdn.pixabay.com/photo/2022/07/24/09/32/flower-7341288_150.jpg",
                                "previewWidth": 150,
                                "previewHeight": 100,
                                "webformatURL": "https://pixabay.com/get/gfdbcf77325e89b21660670fd0539523817886c68e6b7bc156ecef2cdb7ac5d661224bf96ade1996958eda6b9727ba100e3233f94b68688ad09734ce9af12f874_640.jpg",
                                "webformatWidth": 640,
                                "webformatHeight": 427,
                                "largeImageURL": "https://pixabay.com/get/g44da1f6ba98611030c29b0b1b7e7c8526745ef8f124d70f3c9a5062045ec31c7565a58d988433aa54dcaa43e9d9392ad2f778775e74f9aab4aea2e42c307b725_1280.jpg",
                                "imageWidth": 6000,
                                "imageHeight": 4000,
                                "imageSize": 4490213,
                                "views": 26634,
                                "downloads": 21464,
                                "collections": 997,
                                "likes": 98,
                                "comments": 19,
                                "user_id": 37761,
                                "user": "Lolame",
                                "userImageURL": "https://cdn.pixabay.com/user/2019/05/19/22-51-58-56_250x250.jpg"
                            },
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
                status = HttpStatusCode.InternalServerError,
            )
        }
        val repo = PhotoRepositoryImpl(PixabayDataSource(httpClientEngine = mockEngine))
        val emptyQuery = repo.getPhotos(" ", "   ")

        check(emptyQuery is Result.Error)
        Assert.assertTrue(emptyQuery.error is PhotoError.EmptyQuery)

        val result = repo.getPhotos("yellow", "flowers")
        check(result is Result.Error)
        Assert.assertTrue(emptyQuery.error is PhotoError.ServerError)
    }

}