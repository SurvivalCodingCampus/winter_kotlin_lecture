package org.example.day15.Repository


import PhotoDataSource
import PhotoRepositoryImpl
import org.example.day15.Model.Photo
import org.example.day15.Utils.parseJson
import org.example.day15.Utils.readJson


open class PhotoDataSourceImpl(private val jsonDataSource: String) : PhotoDataSource, PhotoRepositoryImpl {
    override var photos: List<Photo>
        get() = parseJson(jsonDataSource)
        set(value) {}

    override suspend fun getPhotos(albumId: Int): List<Photo> {
        return photos.filter { photo -> photo.albumId == albumId }
    }
}


const val photoDataSource = "./src/main/kotlin/day15/RawData/photos.json"

class PhotoRepository : PhotoDataSourceImpl(readJson(photoDataSource)) {
}

