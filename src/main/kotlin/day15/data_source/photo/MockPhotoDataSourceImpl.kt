package day15.data_source.photo

import utils.network.ResponseResult
import utils.network.safeCall
import day15.model.Photo
import day15.util.Urls
import kotlinx.serialization.json.Json

class MockPhotoDataSourceImpl : PhotoDataSource {
    override suspend fun getPhotos(): ResponseResult<List<Photo>> {
        return safeCall {
            Json.decodeFromString<List<Photo>>(Urls.PHOTO_JSON)
        }
    }
}