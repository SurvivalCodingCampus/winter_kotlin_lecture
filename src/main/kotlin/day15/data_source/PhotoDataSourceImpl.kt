package day15.data_source

import day15.model.Photo
import day15.util.JsonData
import kotlinx.serialization.json.Json

class PhotoDataSourceImpl: PhotoDataSource {
    override suspend fun photoData(): List<Photo> {
        return Json.decodeFromString<List<Photo>>(JsonData.PHOTO_DATA)
    }
}