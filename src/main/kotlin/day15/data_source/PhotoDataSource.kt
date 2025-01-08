package org.example.day15.data_source

import kotlinx.serialization.json.Json
import org.example.day15.JsonData.PHOTO_JSON
import org.example.day15.model.Photo

interface PhotoDataSource {
    suspend fun getPhotos(albumId: Int): List<Photo>
}

class PhotoDataSourceImpl : PhotoDataSource {
    override suspend fun getPhotos(albumId: Int): List<Photo> {
        return Json.decodeFromString(PHOTO_JSON)
    }
}