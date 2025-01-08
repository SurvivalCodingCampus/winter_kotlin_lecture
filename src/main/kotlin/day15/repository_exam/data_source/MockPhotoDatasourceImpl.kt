package org.example.day15.repository_exam.data_source

import kotlinx.serialization.json.Json
import org.example.day15.repository_exam.model.Photo
import java.io.File

class MockPhotoDatasourceImpl : PhotoDatasource {
    private val filePath = "photos.txt"
    private val file = File(filePath)

    override suspend fun getPhoto(albumId: Int): Photo? {
        TODO("Not yet implemented")
    }

    override suspend fun savePhoto(photo: Photo) {
        TODO("Not yet implemented")
    }

    override suspend fun getAllPhotos(): List<Photo> {
        return Json.decodeFromString<List<Photo>>(file.readText())
    }
}