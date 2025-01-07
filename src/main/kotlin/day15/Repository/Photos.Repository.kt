package org.example.day15.Repository


import PhotoDataSource
import PhotoRepositoryImpl
import org.example.day15.Model.Photo
import org.example.day15.Utils.parseJson


open class PhotoDataSourceImpl(private val jsonFilePath: String) : PhotoDataSource, PhotoRepositoryImpl {
    override var photos: List<Photo>
        get() = parseJson(jsonFilePath)
        set(value) {}

    override suspend fun getPhotos(albumId: Int): List<Photo> {
        if (photos.isEmpty()) emptyList<String?>()
        return photos.filter { photo -> photo.albumId == albumId }
    }
}


const val photoDataSource = "./src/main/kotlin/day15/RawData/photos.json"

class PhotoRepository : PhotoDataSourceImpl(photoDataSource) {
}

