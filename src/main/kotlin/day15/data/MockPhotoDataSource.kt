package day15.data

import day14.Data
import day15.models.Photo
import kotlinx.serialization.json.Json

class MockPhotoDataSource : PhotoDataSource {
    override suspend fun getPhotos(): List<Photo> = Json.decodeFromString(Data.PHOTOS_STRING)
}