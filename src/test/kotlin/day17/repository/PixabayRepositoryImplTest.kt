package day17.repository

import Constants
import RResult
import day17.PhotoError
import day17.PixabayPhoto
import extractKey
import org.example.day17.data_source.pixabayPhoto.PixabayPhotoDataSourceImp
import io.ktor.client.*
import io.ktor.client.engine.mock.*
import io.ktor.http.*
import io.ktor.utils.io.*
import kotlinx.coroutines.test.runTest
import org.example.day16.utils.ApiClient
import org.example.day17.repository.pixabay.PixabayRepositoryImpl
import org.junit.Assert.assertTrue
import kotlin.test.Test

val mock =
    """ { "total": 289279, "totalHits": 500, "hits": [ { "id": 7679117, "pageURL": "https://pixabay.com/photos/flower-stamens-hypericum-macro-7679117/", "type": "photo", "tags": "flower, stamens, hypericum", "previewURL": "https://cdn.pixabay.com/photo/2022/12/26/13/50/flower-7679117_150.jpg", "previewWidth": 150, "previewHeight": 100, "webformatURL": "https://pixabay.com/get/gfb6a557ffe97156df028e0ef998cab577e5c10186a02d68b4417596d4f16deb918622a13ef8556ccf506d0268956fd60fb26f68e9db016298b1dcd4f9744402b_640.jpg", "webformatWidth": 640, "webformatHeight": 427, "largeImageURL": "https://pixabay.com/get/g3eb0205b04a18080b85b909f29551e1731f7e203831ed0c19c2d2df3dd1e0820a98ece4afa8e6eefc4c94b144838b8a10b16365e9f5ebbdc8cb2d682ddf3d9a3_1280.jpg", "imageWidth": 6000, "imageHeight": 4000, "imageSize": 8137356, "views": 26174, "downloads": 20051, "collections": 844, "likes": 122, "comments": 20, "user_id": 4379051, "user": "Alfred_Grupstra", "userImageURL": "https://cdn.pixabay.com/user/2024/08/25/22-05-08-334_250x250.jpg" }, { "id": 6316445, "pageURL": "https://pixabay.com/photos/rapeseeds-yellow-flowers-6316445/", "type": "photo", "tags": "rapeseeds, yellow, flowers", "previewURL": "https://cdn.pixabay.com/photo/2021/06/06/21/55/rapeseeds-6316445_150.jpg", "previewWidth": 150, "previewHeight": 100, "webformatURL": "https://pixabay.com/get/gd6d9bbbdb4c4a4c7dcf252369b302fbde87020ab5ef16a20796aadb36b1a804bb62884e421aac403a0002500d3c491a80c9a0c764c1230f18e6a284df8175047_640.jpg", "webformatWidth": 640, "webformatHeight": 427, "largeImageURL": "https://pixabay.com/get/g0b5ce736e7b66232928b5c950392d00dd14c8807e56fc560fb430086100bc69f008be7dfefc71cd5a0a785286a48952a1c13f58a0db800a5fcc31436d827aad7_1280.jpg", "imageWidth": 6000, "imageHeight": 4000, "imageSize": 7735260, "views": 37283, "downloads": 29853, "collections": 936, "likes": 88, "comments": 21, "user_id": 11378535, "user": "__Tatius__", "userImageURL": "https://cdn.pixabay.com/user/2020/10/16/11-47-36-873_250x250.jpeg" }, { "id": 4295713, "pageURL": "https://pixabay.com/photos/yellow-poppy-flower-yellow-flower-4295713/", "type": "photo", "tags": "yellow poppy, flower, yellow flower", "previewURL": "https://cdn.pixabay.com/photo/2019/06/24/10/49/yellow-poppy-4295713_150.jpg", "previewWidth": 150, "previewHeight": 99, "webformatURL": "https://pixabay.com/get/gb70efcda050873045ae93445ebe72fd66b8ff952fac694a636788b2200a63af046caf2909689746d9755bd229c0b3ad410347b82cef187a99ebcff56d957c47f_640.jpg", "webformatWidth": 640, "webformatHeight": 426, "largeImageURL": "https://pixabay.com/get/g71743617bcd600a022164c847996f54c60a94f6a754563e03457ab67d5cd6469eb8195679f2cce91547a1f7173f30fb35ddd7337cf5c953697c4f7ac54b75de4_1280.jpg", "imageWidth": 6000, "imageHeight": 4000, "imageSize": 4738491, "views": 9677, "downloads": 5167, "collections": 577, "likes": 71, "comments": 9, "user_id": 7001566, "user": "IngeGG", "userImageURL": "https://cdn.pixabay.com/user/2019/06/19/10-30-15-601_250x250.jpg" }, { "id": 6520851, "pageURL": "https://pixabay.com/photos/flower-yellow-flower-bloom-blossom-6520851/", "type": "photo", "tags": "flower, yellow flower, bloom", "previewURL": "https://cdn.pixabay.com/photo/2021/08/04/02/02/flower-6520851_150.jpg", "previewWidth": 150, "previewHeight": 103, "webformatURL": "https://pixabay.com/get/ga47ece3e3500223407ed383de4147d516179c86c052ababaaef3212ed60790a218775664711efde6237c589a1d671a41ec41ebc1b185a1cb4f12c3ed35632c69_640.jpg", "webformatWidth": 640, "webformatHeight": 439, "largeImageURL": "https://pixabay.com/get/g870ffd45be1dce94b137fb9cd16e8abe8c7069dd47c0f11590259575fcddad32534c26df2cfb33e389bb6e8873719baf50de4bbf3fc0342e35c9ea64088effca_1280.jpg", "imageWidth": 3910, "imageHeight": 2680, "imageSize": 3171422, "views": 17385, "downloads": 9573, "collections": 1443, "likes": 106, "comments": 21, "user_id": 6246704, "user": "fernandozhiminaicela", "userImageURL": "https://cdn.pixabay.com/user/2019/02/27/14-16-13-192_250x250.jpg" }, { "id": 6162613, "pageURL": "https://pixabay.com/photos/yellow-rose-rose-flower-cereal-6162613/", "type": "photo", "tags": "yellow rose, rose, flower", "previewURL": "https://cdn.pixabay.com/photo/2021/04/08/18/59/yellow-rose-6162613_150.jpg", "previewWidth": 150, "previewHeight": 100, "webformatURL": "https://pixabay.com/get/g9b9a4e3ad90b849a500acff0557fc1675d106dae90484200d41297490f9c1ba56830aa596db7fa0bca0d1b51f8ebc2bc82ff64c61f97414963d0c56ef03ef442_640.jpg", "webformatWidth": 640, "webformatHeight": 427, "largeImageURL": "https://pixabay.com/get/g4f5765bc4fa86a795926736c72bf42fc3ade3cba86a19ed0400b2e4b2b154ee9e1ef974d8d5007cbfbf844d34aa2e60c9ee5564a94cdc73645573276a1cb497c_1280.jpg", "imageWidth": 4240, "imageHeight": 2832, "imageSize": 2389361, "views": 56656, "downloads": 42286, "collections": 1834, "likes": 286, "comments": 199, "user_id": 9363663, "user": "Nowaja", "userImageURL": "https://cdn.pixabay.com/user/2020/09/15/15-16-12-52_250x250.jpg" }, { "id": 7927829, "pageURL": "https://pixabay.com/photos/bird-sunbird-olive-backed-sunbird-7927829/", "type": "photo", "tags": "bird, sunbird, olive-backed sunbird", "previewURL": "https://cdn.pixabay.com/photo/2023/04/15/14/21/bird-7927829_150.jpg", "previewWidth": 100, "previewHeight": 150, "webformatURL": "https://pixabay.com/get/g3aa1ff36be5d6f15416ff59f69ea10ba70de8f6e73629d34e13b28a439f30547656b3e2d5974977e3984c6c8a061c0c8bf79cfcea63316984ff73702d492072b_640.jpg", "webformatWidth": 427, "webformatHeight": 640, "largeImageURL": "https://pixabay.com/get/g3005f73d64198f6fc99cc9ca2e75633cfc8e2986806757fdfa2e513a838939200ed601997312c3ad01aece36e2be46300bdfba6b97a5020cfad3bcae6ce94ab2_1280.jpg", "imageWidth": 3758, "imageHeight": 5637, "imageSize": 3640356, "views": 59802, "downloads": 52309, "collections": 1545, "likes": 191, "comments": 38, "user_id": 15871962, "user": "xiSerge", "userImageURL": "https://cdn.pixabay.com/user/2022/06/04/07-00-41-258_250x250.jpg" }, { "id": 7019264, "pageURL": "https://pixabay.com/photos/flower-petal-wet-macro-tulip-7019264/", "type": "photo", "tags": "flower, petal, wet", "previewURL": "https://cdn.pixabay.com/photo/2022/02/17/18/22/flower-7019264_150.jpg", "previewWidth": 150, "previewHeight": 100, "webformatURL": "https://pixabay.com/get/gfa25884510fb7a89211699d944145d1409da68860f116b0fda137bdf18bf98ca1f65795231c91cec81c29b473a84fe1076a26a9ec6f12cd44dbb59ef3c78f890_640.jpg", "webformatWidth": 640, "webformatHeight": 427, "largeImageURL": "https://pixabay.com/get/gf072b58ecb87e1718320f73f8788e461bc263f81a56c612fec886f79324f901d8c15d6c5a38f5555fbda10ebd9842c0232b2a84ded0db709e9ca02f1b2cce9de_1280.jpg", "imageWidth": 6001, "imageHeight": 4000, "imageSize": 3386198, "views": 31868, "downloads": 26180, "collections": 1877, "likes": 160, "comments": 25, "user_id": 19662978, "user": "angelicavaihel", "userImageURL": "https://cdn.pixabay.com/user/2021/03/15/08-35-41-698_250x250.png" }, { "id": 4750726, "pageURL": "https://pixabay.com/photos/flower-petals-bloom-yellow-yellow-4750726/", "type": "photo", "tags": "flower, petals, bloom", "previewURL": "https://cdn.pixabay.com/photo/2020/01/08/17/32/flower-4750726_150.jpg", "previewWidth": 150, "previewHeight": 99, "webformatURL": "https://pixabay.com/get/gd52b235e7b8fb1aa4f2a24ea9e29b210eca1b0148f3c5192c1ee9c9e67b1dec2b6d8523f351eb969449cecf623ee465da13582d9adacfc5b281c23d44ac64f0c_640.jpg", "webformatWidth": 640, "webformatHeight": 425, "largeImageURL": "https://pixabay.com/get/gaf81f1301eec78a9f4fc95b4614f95f2f64f0e5058c86c60e9a0f90fc58bcbc30e43c0ef492e55bacd431ca297791af6e48ebb8ce2d8f351996de6d4ad0923c2_1280.jpg", "imageWidth": 3008, "imageHeight": 2000, "imageSize": 1453867, "views": 10397, "downloads": 7005, "collections": 504, "likes": 64, "comments": 24, "user_id": 14174246, "user": "Zotx", "userImageURL": "https://cdn.pixabay.com/user/2019/11/20/20-56-12-836_250x250.jpg" }, { "id": 6558487, "pageURL": "https://pixabay.com/photos/flowers-coast-sea-yellow-flowers-6558487/", "type": "photo", "tags": "flowers, coast, sea", "previewURL": "https://cdn.pixabay.com/photo/2021/08/19/16/31/flowers-6558487_150.jpg", "previewWidth": 150, "previewHeight": 100, "webformatURL": "https://pixabay.com/get/g0f4f7632c844d61641b064ae9409b2ddfa06e2658203176fc9947486deb929eda45c8b93cca418ee724ce92f495b20ce327390eaa149e217ed9fd4857aa3f23b_640.jpg", "webformatWidth": 640, "webformatHeight": 426, "largeImageURL": "https://pixabay.com/get/gf05c8d9accbb3a55c39709bb370a02eb04a653b51632d5ece9e98f479fc4dba7f6542447e9d02fa80c220589ec9bd563393ac39940eab73e561665098dc709ae_1280.jpg", "imageWidth": 4256, "imageHeight": 2832, "imageSize": 4587665, "views": 177457, "downloads": 149499, "collections": 6051, "likes": 334, "comments": 40, "user_id": 21633244, "user": "lillolillolillo", "userImageURL": "https://cdn.pixabay.com/user/2021/06/09/06-56-51-212_250x250.jpg" }, { "id": 715540, "pageURL": "https://pixabay.com/photos/yellow-flower-blossom-bloom-petals-715540/", "type": "photo", "tags": "yellow, flower, blossom", "previewURL": "https://cdn.pixabay.com/photo/2015/04/10/00/41/yellow-715540_150.jpg", "previewWidth": 150, "previewHeight": 84, "webformatURL": "https://pixabay.com/get/g38d1cd855f5b3b8db9356c8488af4de0a738ed8fd03b834c358d685bd20cb5c462d604ed70a82264327c96e23fca86a3_640.jpg", "webformatWidth": 640, "webformatHeight": 360, "largeImageURL": "https://pixabay.com/get/g6a9d870c4c8c181f34ab3b978d44d5212fd2a8b1f558febcaf41253257b274ea570d6dc7232c2d69788cdc4b2200b530fe10366a3491ac674ba0783594a6c450_1280.jpg", "imageWidth": 3020, "imageHeight": 1703, "imageSize": 974940, "views": 178867, "downloads": 110083, "collections": 2171, "likes": 410, "comments": 54, "user_id": 916237, "user": "Wow_Pho", "userImageURL": "https://cdn.pixabay.com/user/2015/04/07/14-10-15-590_250x250.jpg" }, { "id": 7193390, "pageURL": "https://pixabay.com/photos/flower-ranunculus-petals-dark-7193390/", "type": "photo", "tags": "flower, ranunculus, petals", "previewURL": "https://cdn.pixabay.com/photo/2022/05/13/10/35/flower-7193390_150.jpg", "previewWidth": 150, "previewHeight": 100, "webformatURL": "https://pixabay.com/get/gc9da24b154783babedd13c1c6264a2a920751f79be0cb0dfd18459a20f8a570af26b2b1d99fdc130752ec2108f49804ca24898e769d30860d7702a78732d87d8_640.jpg", "webformatWidth": 640, "webformatHeight": 427, "largeImageURL": "https://pixabay.com/get/gd8d24b1a38e79b1c23f491d83fcf59f35e12b42b8bd02ef133d9f34529b789874f9743951b4a6fcf90fb72ddf9061bdc3321308fbb798b3c9400a2dcaff7a23f_1280.jpg", "imageWidth": 5472, "imageHeight": 3648, "imageSize": 2311191, "views": 13664, "downloads": 9783, "collections": 1267, "likes": 104, "comments": 11, "user_id": 25590070, "user": "nohopuku_photography", "userImageURL": "https://cdn.pixabay.com/user/2023/10/17/09-33-11-665_250x250.jpg" }, { "id": 6553135, "pageURL": "https://pixabay.com/photos/jerusalem-artichoke-flower-6553135/", "type": "photo", "tags": "jerusalem artichoke, flower, yellow flower", "previewURL": "https://cdn.pixabay.com/photo/2021/08/17/13/56/jerusalem-artichoke-6553135_150.jpg", "previewWidth": 150, "previewHeight": 100, "webformatURL": "https://pixabay.com/get/g18b69a81d82aeb20211ca64a9b4d7874c03f5cd687c45abd7d099667f188f346123c3281e46ee56cced1ef1ebe802ed0bedb899bbe1be96a083386e06ec9392f_640.jpg", "webformatWidth": 640, "webformatHeight": 427, "largeImageURL": "https://pixabay.com/get/gf48eb9da0ec85dd17c9e14237dd6eb7db0ff0ccba3389a73b1bcffc00935484f5db5d28035e32dd7af8a8e8f3c34105722bb6880502eca486bb328c86269d1da_1280.jpg", "imageWidth": 6240, "imageHeight": 4160, "imageSize": 2866091, "views": 8355, "downloads": 6085, "collections": 530, "likes": 112, "comments": 59, "user_id": 1195798, "user": "Couleur", "userImageURL": "https://cdn.pixabay.com/user/2024/11/29/15-20-47-533_250x250.jpg" }, { "id": 273391, "pageURL": "https://pixabay.com/photos/flower-yellow-petals-yellow-flower-273391/", "type": "photo", "tags": "flower, yellow petals, yellow flower", "previewURL": "https://cdn.pixabay.com/photo/2014/02/24/05/11/flower-273391_150.jpg", "previewWidth": 150, "previewHeight": 112, "webformatURL": "https://pixabay.com/get/g485f8e0b8725671d10f1f8cd9c807fa359e888baabd11b1b03143991741b26c86448a9adbf5e5f01ae37db5e19f1861c_640.jpg", "webformatWidth": 640, "webformatHeight": 480, "largeImageURL": "https://pixabay.com/get/g1cdff63ec209633d9b00160c59941b408d940c9dd514276781fb8daeb8d783077147d228615d166066fc38692134f2036afe5952bf0aa96ba5218ad29636f063_1280.jpg", "imageWidth": 2607, "imageHeight": 1956, "imageSize": 890318, "views": 25515, "downloads": 9159, "collections": 526, "likes": 86, "comments": 14, "user_id": 152861, "user": "angelac72", "userImageURL": "https://cdn.pixabay.com/user/2014/02/10/02-47-32-118_250x250.jpg" }, { "id": 4936511, "pageURL": "https://pixabay.com/photos/flowers-yellow-flowers-nature-4936511/", "type": "photo", "tags": "flowers, yellow flowers, nature", "previewURL": "https://cdn.pixabay.com/photo/2020/03/16/10/27/flowers-4936511_150.jpg", "previewWidth": 150, "previewHeight": 100, "webformatURL": "https://pixabay.com/get/g3d9e1d72c0c33125e92b5d47d2e3f498a8d0bee580a9351bf35ecd2f669e88c346f8d88fbdfcf9020dcec652c005f16ce4b915b6727457a167eccc88a220ddd7_640.jpg", "webformatWidth": 640, "webformatHeight": 427, "largeImageURL": "https://pixabay.com/get/g21741e02e637177d1861459577a79bf5716ef38ce2aacafab1c3a18069ff1edb196825a77d20fac64f93c4d84152db67b4bd584255905824933339e68ff2b184_1280.jpg", "imageWidth": 5000, "imageHeight": 3333, "imageSize": 2156782, "views": 35385, "downloads": 22601, "collections": 1248, "likes": 127, "comments": 21, "user_id": 3603324, "user": "phtorxp", "userImageURL": "https://cdn.pixabay.com/user/2022/11/27/11-56-03-466_250x250.jpg" }, { "id": 256776, "pageURL": "https://pixabay.com/photos/flowers-yellow-flowers-plants-256776/", "type": "photo", "tags": "flowers, yellow flowers, plants", "previewURL": "https://cdn.pixabay.com/photo/2014/02/02/15/05/flowers-256776_150.jpg", "previewWidth": 150, "previewHeight": 100, "webformatURL": "https://pixabay.com/get/ge90ad323a31f033d35ab6f4b15506b66606fbb19584e8fa5fe4012f46557713ff488c40272ef01b9c1ffe2b2f2f2a4f5_640.jpg", "webformatWidth": 640, "webformatHeight": 428, "largeImageURL": "https://pixabay.com/get/gbab3bd02ca17941c121e3cd6fa148bdfc54c5225aa3d5e1350f6f22f4f4d83fbeed29ff0cba85358c8bf12529342d4c8bb7ce3a54e7ee07a4e9ef602d7d9a13e_1280.jpg", "imageWidth": 3872, "imageHeight": 2592, "imageSize": 2371385, "views": 14728, "downloads": 7433, "collections": 918, "likes": 107, "comments": 22, "user_id": 768, "user": "GLady", "userImageURL": "https://cdn.pixabay.com/user/2023/02/23/18-02-16-112_250x250.jpg" }, { "id": 7341288, "pageURL": "https://pixabay.com/photos/flower-yellow-flower-petals-7341288/", "type": "photo", "tags": "flower, yellow flower, petals", "previewURL": "https://cdn.pixabay.com/photo/2022/07/24/09/32/flower-7341288_150.jpg", "previewWidth": 150, "previewHeight": 100, "webformatURL": "https://pixabay.com/get/g09b617a93fca4df45fda7919ae6a4c62c9e2bbc37c15d4b8ce1a2460171fb670127664a97fb02d80b1a84de0195d379c229ba6158cbb0d70cde37d2c88e23b3f_640.jpg", "webformatWidth": 640, "webformatHeight": 427, "largeImageURL": "https://pixabay.com/get/g3cf864c4fce8a396973d4424d2dde286536e1215830e6f258b83dd5c373a6c8007abd63ce6506cba612dde586a58bbdea740576d8ca25d2f16dcfa6a3904cde4_1280.jpg", "imageWidth": 6000, "imageHeight": 4000, "imageSize": 4490213, "views": 26634, "downloads": 21464, "collections": 997, "likes": 98, "comments": 19, "user_id": 37761, "user": "Lolame", "userImageURL": "https://cdn.pixabay.com/user/2019/05/19/22-51-58-56_250x250.jpg" }, { "id": 6353123, "pageURL": "https://pixabay.com/photos/poppy-flower-yellow-poppy-6353123/", "type": "photo", "tags": "poppy, flower, yellow poppy", "previewURL": "https://cdn.pixabay.com/photo/2021/06/21/09/10/poppy-6353123_150.jpg", "previewWidth": 150, "previewHeight": 100, "webformatURL": "https://pixabay.com/get/gd457f12f5091756e0158c9aa98778c642306b1f1e7e0239d20b8968280285f5ecc3cd0d87c6ab454873989e51ff2a75ec5621931d584717c9c1c2c41b79b6fe5_640.jpg", "webformatWidth": 640, "webformatHeight": 427, "largeImageURL": "https://pixabay.com/get/g6b3b5a3e8b90f06ef37e1147cb66f8275bd3e746ccbdbe940e7a688dbc0e8a23a9fa653ec989e4670dbee1f28df98ad18f8699518dbad6ce49b8692ab868b1b9_1280.jpg", "imageWidth": 6000, "imageHeight": 4000, "imageSize": 2306701, "views": 8939, "downloads": 4148, "collections": 719, "likes": 102, "comments": 62, "user_id": 10084616, "user": "Nennieinszweidrei", "userImageURL": "https://cdn.pixabay.com/user/2022/12/04/11-13-16-116_250x250.png" }, { "id": 1512813, "pageURL": "https://pixabay.com/photos/lilies-yellow-flowers-petals-1512813/", "type": "photo", "tags": "lilies, yellow, flowers", "previewURL": "https://cdn.pixabay.com/photo/2016/07/12/18/54/lilies-1512813_150.jpg", "previewWidth": 150, "previewHeight": 75, "webformatURL": "https://pixabay.com/get/g0f0281fa7d01b8ea1876843620b9b49c7399501ed2459a660e16a561df7f5576ec699a06cd4a32ece4cffd70b0b240b982c3446bd0d0338b225418732f1304c8_640.jpg", "webformatWidth": 640, "webformatHeight": 323, "largeImageURL": "https://pixabay.com/get/g5055e2afff3a4641ada0fc87aeb5fda9830bb1bb308cafb811263aae69c8da0a859802a3e9731a8e688dba4719f999b86d8524eb0eb9ecec12759968114c262f_1280.jpg", "imageWidth": 3861, "imageHeight": 1952, "imageSize": 1037708, "views": 224163, "downloads": 140344, "collections": 3960, "likes": 654, "comments": 66, "user_id": 2364555, "user": "NoName_13", "userImageURL": "https://cdn.pixabay.com/user/2022/12/12/07-40-59-226_250x250.jpg" }, { "id": 2107024, "pageURL": "https://pixabay.com/photos/crocus-flowers-yellow-bloom-2107024/", "type": "photo", "tags": "crocus, flowers, nature", "previewURL": "https://cdn.pixabay.com/photo/2017/02/28/22/37/crocus-2107024_150.jpg", "previewWidth": 150, "previewHeight": 99, "webformatURL": "https://pixabay.com/get/g6628a534ca3f6c804f175e1dfcd9638cd198cbe40223f0b060af0bf01093c1db1e2cbf3391a08174970060e26593820abe36cbab16202130252e7d5477217995_640.jpg", "webformatWidth": 640, "webformatHeight": 426, "largeImageURL": "https://pixabay.com/get/ge16a7a5444114cce12167432583f2c405c576f2da3a76b4a4f973d6e1e1f06ce78e8fd907f0dc0dcc7c9c705dc724bcc86a3ded72e509b97eb4b91488df95ce3_1280.jpg", "imageWidth": 4896, "imageHeight": 3264, "imageSize": 2596169, "views": 111457, "downloads": 71632, "collections": 1422, "likes": 314, "comments": 51, "user_id": 1195798, "user": "Couleur", "userImageURL": "https://cdn.pixabay.com/user/2024/11/29/15-20-47-533_250x250.jpg" }, { "id": 4384750, "pageURL": "https://pixabay.com/photos/flower-yellow-flower-plant-macro-4384750/", "type": "photo", "tags": "flower, yellow flower, plant", "previewURL": "https://cdn.pixabay.com/photo/2019/08/04/20/48/flower-4384750_150.jpg", "previewWidth": 150, "previewHeight": 100, "webformatURL": "https://pixabay.com/get/g2025229cf0156a810e1aaf7d934f02859bf75a63a57f64d1d9473c388e9209db615fc61ba4906c555c4ca28353d668364e1d5550c4918c77ab4746d53402a1d6_640.jpg", "webformatWidth": 640, "webformatHeight": 427, "largeImageURL": "https://pixabay.com/get/g6b4dd50104bb3387bbb3aa16baafda38b940a3dfdde1232c897fb3a7daf102ac8847909e94be5dd93bb1b3e3b8b56de46660d82f94e6e66ed60cc9e138d151ea_1280.jpg", "imageWidth": 5286, "imageHeight": 3532, "imageSize": 1161871, "views": 4998, "downloads": 3511, "collections": 190, "likes": 48, "comments": 26, "user_id": 7520060, "user": "DerWeg", "userImageURL": "https://cdn.pixabay.com/user/2023/07/09/08-27-31-784_250x250.jpg" } ] } """.trimIndent()


class PixabayRepositoryImplTest {
    @Test
    fun `200 working`() = runTest {
        val mockHttpClient = ApiClient(pixabayPhotoEngine).create()
        val repository = createRepository(mockHttpClient, Constants.KEY)

        val result = repository.getPhotos("yellow+flowers")
        require(result is RResult.Success)
        assertTrue(result.data.isNotEmpty())
    }

    @Test
    fun `empty query test`() = runTest {
        val mockHttpClient = ApiClient(pixabayPhotoEngine).create()
        val repository = createRepository(mockHttpClient, Constants.KEY)

        val result = repository.getPhotos("")

        require(result is RResult.Error)
        assertTrue(result.error is PhotoError.EmptyQuery)
    }

    @Test
    fun `wrong api key response`() = runTest {
        val mockHttpClient = ApiClient(pixabayPhotoEngine).create()
        val repository = createRepository(mockHttpClient, "wrongApiKey")

        val result = repository.getPhotos("yellow+flowers")
        require(result is RResult.Error)
        assertTrue(result.error is PhotoError.ServerError)
    }


    @Test
    fun `IOexception Error`() = runTest {
        val httpClient = ApiClient(errorEngine).create()
        val repository = createRepository(httpClient)

        val result = repository.getPhotos("power")
        require(result is RResult.Error)
        assertTrue(result.error is PhotoError.ServerError)
    }

    @Test
    fun `Real API Test`() = runTest {
        val httpClient = ApiClient().create()
        val repository = createRepository(httpClient)

        val result = repository.getPhotos("power")
        require(result is RResult.Success)
        assertTrue(result.data.isNotEmpty())
    }


    private fun createRepository(client: HttpClient, apiKey: String = Constants.KEY): PixabayRepositoryImpl {
        val dataSource = PixabayPhotoDataSourceImp(client, apiKey)
        return PixabayRepositoryImpl(dataSource)
    }

    private fun handleResult(result: RResult<List<PixabayPhoto>, PhotoError>) {
        when (result) {
            is RResult.Success -> result.data.forEach { photo ->
                println(photo.imageUrl)
            }

            is RResult.Error -> handleError(result.error)

            else -> throw Exception("Unexpected error occurred.")
        }
    }

    private fun handleError(error: PhotoError) {
        when (error) {
            is PhotoError.NetworkError -> println(error.toMessage())
            is PhotoError.EmptyQuery -> println(error.toMessage())
            is PhotoError.ServerError.UnknownError -> println(error.toMessage())
            is PhotoError.ServerError.IOException -> throw Exception("IO error")
            is PhotoError.ServerError.InternalServerError -> println(error.toMessage())
            else -> println(error.toMessage())
        }
    }

    private val pixabayPhotoEngine = MockEngine { request ->
        when (request.url.toString()) {
            "${Constants.BASE_URL}?key=${Constants.KEY}&q=yellow+flowers&image_type=photo&pretty=true" -> {
                respond(
                    content = ByteReadChannel(mock),
                    status = HttpStatusCode.OK,
                    headers = headersOf("Content-Type", "text/xml")
                )
            }

            else -> {
                if (extractKey(request.url.toString()) != Constants.KEY) {
                    respond(
                        content = ByteReadChannel("[ERROR 400] Invalid API key. Note: This value is case-sensitive."),
                        status = HttpStatusCode.BadRequest,
                    )
                } else {
                    respond(
                        content = ByteReadChannel(byteArrayOf()), status = HttpStatusCode.BadRequest
                    )
                }
            }
        }
    }

    private val errorEngine = MockEngine { _ ->
        respond(
            content = "Internal Server Error",
            status = HttpStatusCode.InternalServerError,
            headers = headersOf("Content-Type", "text/plain")
        )
    }
}